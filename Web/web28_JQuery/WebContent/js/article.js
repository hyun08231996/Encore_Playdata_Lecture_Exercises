$(function () {
    	//alert($('p').length);
    	
    	var firstP = $('p:eq(1)');
    	//alert(firstP.html()); //text()....val()사용 안된다.
    	
    	$('a.more').click(function(){
    		if(firstP.is(':hidden')){ //2번째 p태그가 안보인다면
    			firstP.slideToggle('slow');
    			$(this).html('read less');
    		}else{
    			firstP.slideToggle('slow');
    			$(this).html('read more');
    		}
    	});//click
    	
    	//현재 글자크기를 먼저 알아낸다
    	var speech = $('div.speech');
    	var defaultSize = speech.css('fontSize');
    	//alert(defaultSize); //19.2
    	
    	var num = parseInt(defaultSize, 10);
    	//alert(num);//19
    	
    	$('#switcher>button').click(function(){
    		switch(this.id){
    		case 'switcher-large':
    			num += 5;
    			break;
    			
    		case 'switcher-small':
    			num -= 5;
    			break;
    			
    		default:
    			num = parseInt(defaultSize, 10);
    		}//switch
    		
    		//반드시 animate() 적용해야 한다
    		speech.animate({fontSize:num+'px'}, 'fast');
    	});//click
	});