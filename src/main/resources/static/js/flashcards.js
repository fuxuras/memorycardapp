// variables
const deckNameElement = document.getElementById('deck-name');
const cardElement = document.getElementById('card');
const frontCardElement = document.getElementById('front-card');
const frontCardTextElement = document.getElementById('front-card-text');
const backCardElement = document.getElementById('back-card');
const backCardTextElement = document.getElementById('back-card-text');
const prevButtonElement = document.getElementById('prev-button');
const nextButtonElement = document.getElementById('next-button');
const cards = deck.cards;

// initialize
let index = 0;
let showingAnswer = false;
deckNameElement.innerHTML = deck.name;
updateCard();

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
    frontCardElement.style.transform = 'translateX(-20%)';
    backCardElement.style.transform = 'translateX(40%)';
    showingAnswer = true;
}

function hideAnswer() {
    frontCardElement.style.transform = 'translateX(0)';
    backCardElement.style.transform = 'translateX(0)';
    showingAnswer = false;
}