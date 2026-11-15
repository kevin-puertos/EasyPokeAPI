
const API_URL = 'http://localhost:8080/api/v1/pokemons';

const gridContainer = document.getElementById('pokemon-grid');

function loadPokemons(){
    fetch(API_URL)
    .then(response =>{
        if(!response.ok) throw new Error('ERRROR CONECTANDO CON EL BACKEND');
        return response.json();
    })
    .then(pokemons => {
            gridContainer.innerHTML = '';

            pokemons.forEach(pokemon => {
                const pokemonItem = document.createElement('div');
                pokemonItem.classList.add('pokemon-item');

                pokemonItem.innerHTML =  pokemonItem.innerHTML = `
                <div>
                <a href ="pokemon-detail.html?id=${String(pokemon.id)}">
                    <div class="pokemonId">#${String(pokemon.id).padStart(3, '0')}</div>

                    <img alt="${pokemon.name}" src="${pokemon.image_url}" width="150px" height="150px">
                    <p class="pokemon-name-text">${pokemon.name}</p>
        
                    <div class="pokemon-types">
                    ${pokemon.types.map(t => `<span class="${t.typeName.toLowerCase()}">${t.typeName}</span>`).join('')}
                    </div>
                </a>
                </div>
`;

                gridContainer.appendChild(pokemonItem);
            });
        })
        .catch(error => {
            console.error('Error: ',error);
            gridContainer.innerHTML = '<p>Error al cargar el catálogo de Pokemones</p>';
        });

}

document.addEventListener('DOMContentLoaded',loadPokemons)








