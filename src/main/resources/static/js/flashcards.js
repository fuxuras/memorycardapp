// variables
const decksElement = document.getElementById('decks')
const deckNameElement = document.getElementById('deck-name');
const cardElement = document.getElementById('card');
const frontCardElement = document.getElementById('front-card');
const frontCardTextElement = document.getElementById('front-card-text');
const backCardElement = document.getElementById('back-card');
const backCardTextElement = document.getElementById('back-card-text');
const prevButtonElement = document.getElementById('prev-button');
const nextButtonElement = document.getElementById('next-button');
const addCardButtonElement = document.getElementById('addCard')
let currentDeck;
let cards;

// initialize
initializeDecks()
let index = 0;
let showingAnswer = false;


function initializeDecks() {
    for(let i = 0; i < decks.length; i++){
        decksElement.innerHTML += '<button class="shadow-lg bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded" ' +
            'id=' + decks[i].name +' >' + decks[i].name + '</button>';
    }
    for (let i = 0; i < decks.length; i++) {
        document.getElementById(decks[i].name).addEventListener(
            'click',() => {
                currentDeck = decks[i];
                cards = currentDeck.cards;
                initializeCards();
            }
        )
    }
}


function initializeCards() {
    index = 0;
    showingAnswer = false;
    deckNameElement.innerHTML = currentDeck.name;
    updateCard();
}

// event listeners
prevButtonElement.addEventListener('click', () => {
    index--;
    updateCard();
});

nextButtonElement.addEventListener('click', () => {
    index++;
    updateCard();
});

cardElement.addEventListener('click', () => {
    if (showingAnswer) {
        hideAnswer();
    } else {
        showAnswer();
    }
});

// functions
function updateCard() {
    backCardTextElement.style.visibility = 'hidden';
    hideAnswer();
    index = (index + cards.length) % cards.length;
    frontCardTextElement.innerHTML = cards[index].front;
    backCardTextElement.innerHTML = cards[index].back;
}

function showAnswer() {
    backCardTextElement.style.visibility = 'visible';
    backCardElement.style.transform = 'translateY(60%)';
    showingAnswer = true;
}

function hideAnswer() {
    backCardElement.style.transform = 'translateY(0)';
    showingAnswer = false;
}