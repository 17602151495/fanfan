$(function () {
    $("#table").BT({
        url: baseURL + 'hotel/hotel/list',
        columns: [
            {checkbox: true},
			{ title: '店长ID', field: 'userid'}, 			
			{ title: '店铺名字', field: 'name'}, 			
			{ title: '联系电话', field: 'tel'}, 			
			{ title: '店铺图片', field: 'hotelpic'}, 			
			{ title: '店铺介绍', field: 'introduce'}, 			
			{ title: '营业开始时间', field: 'startime'}, 			
			{ title: '营业结束时间', field: 'endtime'}, 			
			{ title: '省', field: 'province'}, 			
			{ title: '市', field: 'city'}, 			
			{ title: '县区', field: 'county'}, 			
			{ title: '详细地址', field: 'address'}, 			
			{ title: '经度', field: 'longitude'}, 			
			{ title: '纬度', field: 'latitude'}, 			
			{ title: '店铺分类（1饭店 2 酒店 3快餐店 4 食堂）', field: 'classification'}, 			
			{ title: '经营类型（1烧烤香锅 2 休闲茶饮 3中餐地方 3.1 鲁菜）', field: 'mtype'}, 			
			{ title: '级别 1 总店 2 分店 3 连锁店', field: 'level'}, 			
			{ title: '经营状态（1营业中 2 暂停营业 3即将开业）', field: 'mstate'}, 			
			{ title: '店铺状态 （正常 ，下线，欠费,违规） ', field: 'sta'}, 			
			{ title: '', field: 'createTime'}, 			
			{ title: '', field: 'updateTime'}, 			
			{ title: '', field: 'createby'}, 			
			{ title: '', field: 'updateby'}			
        ],
		//条件查询
        queryParams:vm.params
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		params:{
		    name:'',
		},
		hotel: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hotel = {};
		},
		update: function (event) {
           	var id = getSelectedRowId("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.hotel.id == null ? "hotel/hotel/save" : "hotel/hotel/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hotel),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRowsId("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hotel/hotel/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "hotel/hotel/info/"+id, function(r){
                vm.hotel = r.hotel;
            });
		},
		reload: function (event) {
			vm.showList = true;
			//刷新 如需条件查询common.js
            $("#table").BTF5();
		}
	}
});