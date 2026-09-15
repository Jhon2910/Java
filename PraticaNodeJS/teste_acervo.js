const acervo = require('./acervo');

console.log('Teste de busca por "Memórias":');
console.log(acervo.buscar('Memórias'));

console.log('\nTeste de busca por "Dom":');
console.log(acervo.buscar('Dom'));

console.log('\nTeste com termo inexistente:');
console.log(acervo.buscar('Livro que nao existe'));