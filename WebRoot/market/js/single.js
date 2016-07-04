	$(document).ready(function($){
		judgeIsLogin();
		var goodsId = $.getUrlParam('goodsId');
		getGoodsById(goodsId);
	});
	function getGoodsById(goodsId) {
		$.ajax({
			type:'POST',
			url:'getGoodsById',
			data:{goodsId:goodsId},
			dataType:'json',
			success:function (data) {
				if(data.successInfo.success==true){
					var goodsInfo = data.goodsInfoMap;

					$('.preview-img1').attr('src',goodsInfo.goodsImg);
					$('.preview-img2').attr('src',goodsInfo.goodsImg);
					$('.preview-img3').attr('src',goodsInfo.goodsImg);

					$('#goods_name').html(goodsInfo.goodsName);
					$('#goods_description').html(goodsInfo.goodsDescription);
					$('#goods_price').html('$'+goodsInfo.goodsPrice);
					$('#add_to_cart').bind('click',function () {
						var userId = $.cookie('userId');
						if(userId !== 'null'){
							var goodsId = $(this).children('.goodsId').val();
							insertShopcar(userId,goodsId);
						}else{
							$('#login-link').click();
						}
					})
					getRelatedGoods(goodsInfo.categoryId);
				}
			},complete:function () {
				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 700,
					source_image_height: 800,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){}
				});
				$('.dropdownlist').change(function(){
					etalage_show( $(this).find('option:selected').attr('class') );
				});
			}
		});
	}

	function getRelatedGoods(categoryId) {
		$.ajax({
			type:'POST',
			url:'getGoodsByCategoryId',
			data:{categoryId:categoryId},
			dataType:'json',
			success:function (data) {
				if(data.successInfo.success==true){
					var related_goods_number = 0;
					$.each(data.allGoodsInfo,function (index,item) {
						if(related_goods_number < 4){
							var module = $('#module').clone(true);
							module.removeAttr('id');
							module.find('.related-goods-link').attr('href','single.html?goodsId='+item.goodsId);
							module.find('.related-goods-img').attr('src',item.goodsImg);
							module.find('.related-goods-name').text(item.goodsName);
							module.find('.goodsId').val(item.goodsId);
							$('#related-goodsList').append(module);
							related_goods_number++;
						}
					})
				}
			},
			complete:function () {
			$('.add-to-cart').bind('click',function () {
				var userId = $.cookie('userId');
				if(userId !== 'null'){
					var goodsId = $(this).children('.goodsId').val();
					insertShopcar(userId,goodsId);
				}else{
					$('#login-link').click();
				}		
			})
		}
		});
	}

