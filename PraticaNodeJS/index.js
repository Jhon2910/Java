const http = require('http');
const fs = require('fs');
const path = require('path');
const acervo = require('./acervo');

function gerarHTMLComResultados(termo, listaDeLivros) {
    let html = `<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Resultado da Busca</title>
</head>
<body>
    <h1>Resultados para: ${termo || ''}</h1>`;

    if (listaDeLivros.length === 0) {
        html += '<p>Nenhum livro encontrado.</p>';
    } else {
        html += `<table border="1">
        <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>Localizador</th>
        </tr>`;

        listaDeLivros.forEach(livro => {
            html += `<tr>
                <td>${livro.titulo}</td>
                <td>${livro.autor}</td>
                <td>${livro.localizador}</td>
            </tr>`;
        });

        html += '</table>';
    }

    html += '<p><a href="/">Voltar para a busca</a></p>';
    html += '</body></html>';
    return html;
}

const servidor = http.createServer((req, res) => {
    let url = new URL(`http://localhost:3000${req.url}`);

    if (url.pathname === '/buscarNoAcervo') {
        let termo = url.searchParams.get('termo');
        let resultado = acervo.buscar(termo);
        let html = gerarHTMLComResultados(termo, resultado);

        res.setHeader('Content-Type', 'text/html; charset=utf-8');
        res.end(html);
        return;
    }

    let arquivo = url.pathname === '/' ? 'index.html' : url.pathname.substring(1);
    let caminhoArquivo = path.join(__dirname, arquivo);

    fs.readFile(caminhoArquivo, (err, data) => {
        if (err) {
            res.statusCode = 404;
            res.setHeader('Content-Type', 'text/html; charset=utf-8');
            res.end(`<html><body>
                <h1>Erro 404! Recurso não existe!</h1>
            </body></html>`);
            return;
        }

        if (arquivo.endsWith('.html')) {
            res.setHeader('Content-Type', 'text/html; charset=utf-8');
        } else {
            res.setHeader('Content-Type', 'application/octet-stream');
        }

        res.end(data);
    });
});

servidor.listen(3000, () => {
    console.log('Acesse este servidor em http://localhost:3000/');
    console.log('Para pará-lo, aperte Ctrl-C');
});