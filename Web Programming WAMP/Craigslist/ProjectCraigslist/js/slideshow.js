$(document).ready(function() {
$(function(){
						$('.fadein span:gt(0)').hide();
							setInterval(function(){
							$('.fadein span:first-child').fadeOut()
							.next('span').fadeIn()
							.end().appendTo('.fadein');}, 
							5000);
								});<!--end of function -->
					
});