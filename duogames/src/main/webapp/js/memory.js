
var words = [$('#pairs')];
//var indexOf = $('#pairs.size()');


$(document).ready(function() {
    console.log('hello');
    console.log(words);
    console.log($('#nrof').get(0)['value']);
    console.log($('#hidden').get(0)['value']);
    //console.log(indexOf);
    
    $('#mem_card_0').bind('slide.bs.carousel', function (e) {
    console.log('start slide!');
    console.log($('#word_0').html());
});

$('#mem_card_0').bind('slid.bs.carousel', function (e) {
    console.log("end slide!");
});
    
    
});