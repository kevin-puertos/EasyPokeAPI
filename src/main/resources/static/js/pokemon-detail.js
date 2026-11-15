const params = new URLSearchParams(window.location.search);
const id = params.get('id');

const API_URL = `http://localhost:8080/api/v1/pokemons/detail/${id}`;

async function getPokemon() {
    try {

        if (!id) {
            throw new Error("Pokemon ID not provided");
        }

        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Pokemon not found");
        }

        const pokemon = await response.json();

        renderPokemon(pokemon);

    } catch (error) {
        console.error(error);
    }
}


function renderPokemon(pokemon) {

    // Información general
    document.getElementById("pokemon-id").textContent =
        `#${String(pokemon.id).padStart(3, '0')}`;

    document.getElementById("pokemon-name").textContent =
        pokemon.name;

    document.getElementById("pokemon-image").src =
        pokemon.image_url;

    document.getElementById("pokemon-image").alt =
        pokemon.name;


    renderTypes(pokemon.types);
    renderStats(pokemon.stats);
    renderAbilities(pokemon.abilities);
    renderMoves(pokemon.movements);
}


function renderTypes(types = []) {

    const container = document.getElementById("pokemon-types");

    container.innerHTML = types.map(type => `
        <span class="type ${type.typeName.toLowerCase()}">
            ${type.typeName}
        </span>
    `).join('');
}


function renderStats(stats) {

    const container = document.getElementById("pokemon-stats");

    if (!stats) return;

    const statsList = [
        { name: "HP", value: stats.hp },
        { name: "Ataque", value: stats.atk },
        { name: "Defensa", value: stats.def },
        { name: "Ataque especial", value: stats.ataEsp },
        { name: "Defensa especial", value: stats.defEsp },
        { name: "Velocidad", value: stats.spe }
    ];

    container.innerHTML = statsList.map(stat => `
        <div class="stat-row">
            <span class="stat-name">${stat.name}</span>

            <div class="stat-bar">
                <div class="stat-fill"
                     style="width: ${Math.min(stat.value / 255 * 100, 100)}%">
                </div>
            </div>

            <span class="stat-value">${stat.value}</span>
        </div>
    `).join('');
}


function renderAbilities(abilities = []) {

    const container = document.getElementById("pokemon-abilities");

    container.innerHTML = abilities.map(ability => `
        <span class="ability">
            ${ability.name}
        </span>
    `).join('');
}


function renderMoves(movements = []) {

    const container = document.getElementById("pokemon-moves");

    container.innerHTML = movements.map(move => `
        <tr>
            <td>${move.name}</td>
            <td>${move.typeMove ?? '-'}</td>
            <td>${move.power == 0 ? ' - ':move.power }</td>
            <td>${move.accuracy == 0 ? ' - ' :move.accuracy}</td>
            <td>${move.pp ?? '-'}</td>
            <td>${move.description}</td>
        </tr>
    `).join('');
}


getPokemon();