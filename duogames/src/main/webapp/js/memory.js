function thing(){
    console.log('hello');
}

var result;
    
$(document).ready(function() {
    var words = $('#hidden').get(0)['value'];
    var nrOfPairs = $('#nrof').get(0)['value'];
    var openCards = 0;
    
    var card1 = null;
    var card2 = null;
    var word1 = null;
    var word2 = null;
    
    $('#m_0_card_0').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_0').html();
    }
    if (word1 !== $('#word_0').html() && word2 === null){
        word2 = $('#word_0').html();
    }
    if(card1 === null){
        card1 = $('m_0_card_0');
    } else if (card2 === null){
        card2 = $('m_0_card_0');
    }
    if(openCards === 2){
        openCards = 0;
        
        if(callEquals(word1, word2)){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_1_card_1').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_1').html();
    }
    if (word1 !== $('#word_1').html() && word2 === null){
        word2 = $('#word_1').html();
    }
    if(card1 === null){
        card1 = $('m_1_card_1');
    } else if (card2 === null){
        card2 = $('m_1_card_1');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });

    $('#m_2_card_2').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_2').html();
    }
    if (word1 !== $('#word_2').html() && word2 === null){
        word2 = $('#word_2').html();
    }
    if(card1 === null){
        card1 = $('m_2_card_2');
    } else if (card2 === null){
        card2 = $('m_2_card_2');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_3_card_3').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_3').html();
    }
    if (word1 !== $('#word_3').html() && word2 === null){
        word2 = $('#word_3').html();
    }
    if(card1 === null){
        card1 = $('m_3_card_3');
    } else if (card2 === null){
        card2 = $('m_3_card_3');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_4_card_4').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_4').html();
    }
    if (word1 !== $('#word_4').html() && word2 === null){
        word2 = $('#word_4').html();
    }
    if(card1 === null){
        card1 = $('m_4_card_4');
    } else if (card2 === null){
        card2 = $('m_4_card_4');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });

    $('#m_5_card_5').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_5').html();
    }
    if (word1 !== $('#word_5').html() && word2 === null){
        word2 = $('#word_5').html();
    }
    if(card1 === null){
        card1 = $('m_5_card_5');
    } else if (card2 === null){
        card2 = $('m_5_card_5');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_6_card_6').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_6').html();
    }
    if (word1 !== $('#word_6').html() && word2 === null){
        word2 = $('#word_6').html();
    }
    if(card1 === null){
        card1 = $('m_6_card_6');
    } else if (card2 === null){
        card2 = $('m_6_card_6');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_7_card_7').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_7').html();
    }
    if (word1 !== $('#word_7').html() && word2 === null){
        word2 = $('#word_7').html();
    }
    if(card1 === null){
        card1 = $('m_7_card_7');
    } else if (card2 === null){
        card2 = $('m_7_card_7');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_8_card_8').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_8').html();
    }
    if (word1 !== $('#word_8').html() && word2 === null){
        word2 = $('#word_8').html();
    }
    if(card1 === null){
        card1 = $('m_8_card_8');
    } else if (card2 === null){
        card2 = $('m_8_card_8');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_9_card_9').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_9').html();
    }
    if (word1 !== $('#word_9').html() && word2 === null){
        word2 = $('#word_9').html();
    }
    if(card1 === null){
        card1 = $('m_9_card_9');
    } else if (card2 === null){
        card2 = $('m_9_card_9');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_10_card_10').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_10').html();
    }
    if (word1 !== $('#word_10').html() && word2 === null){
        word2 = $('#word_10').html();
    }
    if(card1 === null){
        card1 = $('m_10_card_10');
    } else if (card2 === null){
        card2 = $('m_10_card_10');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });
    
    $('#m_11_card_11').bind('slide.bs.carousel', function () {
    openCards++;
    if(word1 === null){
        word1 = $('#word_11').html();
    }
    if (word1 !== $('#word_11').html() && word2 === null){
        word2 = $('#word_11').html();
    }
    if(card1 === null){
        card1 = $('m_11_card_11');
    } else if (card2 === null){
        card2 = $('m_11_card_11');
    }
    if(openCards === 2){
        openCards = 0;
        callEquals(word1, word2);
        if(result){
            console.log('true');
            card1.setAttribute('class', 'hidden-xs');
            card2.setAttribute('class', 'hidden-xs');
        } else {
            console.log('false');
            card1.carousel('next');
            card2.carousel('next');
        }
        card1 = null;
        card2 = null;
        word1 = null;
        word2 = null;
    }
    });

        //document.getElementById('m_1_card_1').setAttribute('class', 'carousel slide');
        //document.getElementById('m_1_card_1').setAttribute('class', 'hidden-xs');
    //console.log($('#word_0').html());

    $('#mem_card_1').bind('slid.bs.carousel', function () {
        console.log("end slide!");
    });
    
    
});

function reset(){
    
}