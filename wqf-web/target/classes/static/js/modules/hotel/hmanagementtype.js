$(function () {
    $("#table").BT({
        url: baseURL + 'hotel/hmanagementtype/list',
        columns: [
            {checkbox: true},
			{ title: '经营类型名字', field: 'tyname'}, 			
			{ title: '上级ID', field: 'pid'}			
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
		hManagementType: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hManagementType = {};
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
			var url = vm.hManagementType.id == null ? "hotel/hmanagementtype/save" : "hotel/hmanagementtype/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hManagementType),
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
				    url: baseURL + "hotel/hmanagementtype/delete",
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
			$.get(baseURL + "hotel/hmanagementtype/info/"+id, function(r){
                vm.hManagementType = r.hManagementType;
            });
		},
		reload: function (event) {
			vm.showList = true;
			//刷新 如需条件查询common.js
            $("#table").BTF5();
		}
	}
});