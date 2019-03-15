function handleResult() {
    var result = $('#result').get(0)['value'];
    console.log(result);
    if (result === 'true') {
        disableCards();
        openCards = 0;
        correctPairs++;
        if (correctPairs === parseInt(nrOfPairs, 10)) {
            endGame();
        }
    } else {
        card1_extra = card1;
        card2_extra = card2;
        document.getElementById('overlay').setAttribute('style', 'display: inline');
        sleep(800).then(() => {
            turnCards();
        });
    }
    sleep(1600).then(() => {
        resetVars();
    });
}

function disableCards() {
    document.getElementById(card1).getElementsByTagName('a')[0].setAttribute('style', 'display: none');
    document.getElementById(card1).getElementsByTagName('a')[1].setAttribute('style', 'display: none');
    document.getElementById(card2).getElementsByTagName('a')[0].setAttribute('style', 'display: none');
    document.getElementById(card2).getElementsByTagName('a')[1].setAttribute('style', 'display: none');
}
function turnCards() {
    openCards = -2;
    document.getElementById(card1_extra).getElementsByTagName('a')[1].click();
    document.getElementById(card2_extra).getElementsByTagName('a')[1].click();
    sleep(800).then(() => {
        document.getElementById('overlay').setAttribute('style', 'display: none');
    });
}
function incAndCheckCards() {
    openCards++;
    if (openCards === 2) {
        callEquals(word1, word2);
    }
}
function setVars(currentWord, currentCard) {
    if (word1 === null) {
        word1 = currentWord;
    }
    if (word1 !== currentWord && word2 === null) {
        word2 = currentWord;
    }
    if (card1 === null) {
        card1 = currentCard;
    } else if (card1 !== currentCard && card2 === null) {
        card2 = currentCard;
    }
}
function resetVars() {
    card1 = null;
    card2 = null;
    word1 = null;
    word2 = null;
}
const sleep = (milliseconds) => {
    return new Promise(resolve => setTimeout(resolve, milliseconds))
}
var nrOfPairs;
var correctPairs = 0;
var card1 = null;
var card1_extra = null;
var card2 = null;
var card2_extra = null;
var word1 = null;
var word2 = null;
var openCards = 0;

$(document).ready(function () {
    nrOfPairs = $('#nrof').get(0)['value'];

    $('#m_0_card_0').bind('slid.bs.carousel', function () {
        var currentWord = $('#word_0').html();
        var currentCard = 'm_0_card_0';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_1_card_1').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_1').html();
        var currentCard = 'm_1_card_1';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_2_card_2').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_2').html();
        var currentCard = 'm_2_card_2';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_3_card_3').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_3').html();
        var currentCard = 'm_3_card_3';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_4_card_4').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_4').html();
        var currentCard = 'm_4_card_4';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_5_card_5').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_5').html();
        var currentCard = 'm_5_card_5';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_6_card_6').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_6').html();
        var currentCard = 'm_6_card_6';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_7_card_7').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_7').html();
        var currentCard = 'm_7_card_7';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_8_card_8').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_8').html();
        var currentCard = 'm_8_card_8';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_9_card_9').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_9').html();
        var currentCard = 'm_9_card_9';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_10_card_10').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_10').html();
        var currentCard = 'm_10_card_10';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });

    $('#m_11_card_11').bind('slide.bs.carousel', function () {
        var currentWord = $('#word_11').html();
        var currentCard = 'm_11_card_11';
        setVars(currentWord, currentCard);
        incAndCheckCards();
    });
});
