const params = new URLSearchParams(window.location.search);
const id = params.get('id'); 



const API_URL = `http://localhost:8080/api/v1/pokemons/detail/${id}`;

const pokemonContainer = document.getElementById("pokemon-container")

async function getPokemon() {
    try {
        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Pokemon not found");
        }
        const pokemon = response.json();
        renderPokemon(pokemon);

    } catch (error) {
        console.error(error);
    }
}


function renderPokemon(pokemon){

        pokemonContainer.innerHTML = `
        
        <div>
                <a href ="pokemon-detail.html?id=${String(pokemon.id)}">
                    <div class="pokemonId">#${String(pokemon.id).padStart(3, '0')}</div>

                    <img alt="${pokemon.name}" src="${pokemon.image_url}" width="150px" height="150px">
                    <p class="pokemon-name-text">${pokemon.name}</p>
        
                    <div class="pokemon-types">
                    ${pokemon.types.map(t => `<span class="${t.typeName.toLowerCase()}">${t.typeName}</span>`).join('')}
                    </div>

                    <div class="pokemon-abilities">
                    ${pokemon.abilities.map(t => `<span class="${t.typeName.toLowerCase()}">${t.typeName}</span>`).join('')}
                    </div>

                </a>
                </div> 

        
            <div class="moves-information">
                <img src="${response}">

        
            </div>
        
        
        
        `


}