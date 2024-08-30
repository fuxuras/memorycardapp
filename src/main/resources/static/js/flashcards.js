// variables
const deckNameElement = document.getElementById('deck-name');
const flashcardElement = document.getElementById('flash-card');
const cardTextElement = document.getElementById('card-text');
const answerElement = document.getElementById('answer');
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

flashcardElement.addEventListener('click', () => {
    if (showingAnswer) {
        hideAnswer();
    } else {
        showAnswer();
    }
});

// functions
function updateCard() {
    answerElement.style.visibility = 'hidden';
    hideAnswer();
    index = (index + cards.length) % cards.length;
    cardTextElement.innerHTML = cards[index].front;
    answerElement.innerHTML = cards[index].back;
}

function showAnswer() {
    answerElement.style.visibility = 'visible';
    answerElement.style.transform = 'translateY(0)';
    showingAnswer = true;
}

function hideAnswer() {
    answerElement.style.transform = 'translateY(100%)';
    showingAnswer = false;
}