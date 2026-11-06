function somar(param) {

    return Number.parseFloat(param.valor + param.valor);
}


console.log(somar("abacate"));

somar({
    nome: "joaozinho",
    "endereco": "franquinha"
})

console.log(somar({valor: 5}))

console.log(somar(34))
somar(34.5677);

console.log('fim')