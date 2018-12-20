
$(function() {
    $('#userTable').datagrid({
        method:'post',
        url : 'user/getTable',
        pagination : true,
        pageSize : 20,
        pageList : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
        fitColumns : false,
        nowrap : false,
        idField : 'id',
        singleSelect:true,
        striped:true,
        rownumbers:true,
        columns : [[ {
            title : '用户名',
            field : 'userid',
            align : 'center',
            width : '20%'
        }, {
            title : '姓名',
            field : 'username',
            align : 'center',
            width : '25%'
        }, {
            title : '联系方式',
            field : 'mobile',
            align : 'center',
            width : '20%'
        }, {
            title : '邮箱',
            field : 'email',
            align : 'center',
            width : '20%'
        },{
            field : 'opt',
            title : '操作选项',
            align : 'center',
            width : '15%',
            formatter:function(value,row,index){
                var handleHtml = "";
                handleHtml += '<a href="javascript:void(0);" onclick="edit(\''+row.id+'\')">修改</a>&nbsp;';
                handleHtml += '<a href="javascript:void(0);" onclick="del(\''+row.id+'\')">删除</a>&nbsp;';
                return handleHtml;
            }
        }] ],
        onLoadSuccess: function() {
            $('.pagination').pagination({
                layout: ['first', 'prev', 'links', 'next', 'last']
            });
        }
    });
});

function  add() {
    var win;
    win = $("<div></div>").dialog({
        title:'新增用户',
        width:700,
        height:400,
        modal:true,
        href:'system/user/toAdd',
        onClose:function(){
            $(this).dialog("destroy");
        },
        buttons:[{
            text:'保存',
            id: 'saveIcon',
            handler:function(){
                $("#userForm").form('submit',{
                    type:'POST',
                    url : 'system/user/save',
                    success:function(responseData){
                        if(responseData){
                            var data = $.parseJSON(responseData);
                            $.messager.show({"title":"系统提示","msg":data.message,"timeout":1000});

                            if(data.success){
                                win.dialog('destroy');
                                reload();
                            }
                        }
                    }
                });
            }
        },{
            text:'取消',
            id: 'cancelIcon',
            handler:function(){
                win.dialog('destroy');
            }
        }]
    });
}
//reload
function reload() {
    $("#userTable").datagrid("reload");
}

function  edit(id) {
    var win;
    win = $("<div></div>").dialog({
        title:'修改用户',
        width:700,
        height:400,
        modal:true,
        href:'system/user/toEdit/'+id,
        onClose:function(){
            $(this).dialog("destroy");
        },
        buttons:[{
            text:'保存',
            id: 'saveIcon',
            handler:function(){
                $("#userForm").form('submit',{
                    type:'POST',
                    url : 'system/user/save',
                    success:function(responseData){
                        if(responseData){
                            var data = $.parseJSON(responseData);
                            $.messager.show({"title":"系统提示","msg":data.message,"timeout":1000});
                            if(data.success){
                                win.dialog('destroy');
                                reload();
                            }
                        }
                    }
                });
            }
        },{
            text:'取消',
            id: 'cancelIcon',
            handler:function(){
                win.dialog('destroy');
            }
        }]
    });
}

function  del(id) {
    $.messager.confirm("提示","确定删除此记录吗？",function(r){
        if(r){
            $.ajax({
                type:"POST",
                url:'system/user/del/' + id,
                dataType:"json",
                success:function(data){
                    if(data){
                        $.messager.show({"title":"系统提示","msg":data.message,"timeout":1000});
                        if(data.success){
                            reload();
                        }
                    }
                }
            });
        }
    });
}

//搜索
function doSearch() {
    $("#userTable").datagrid("load", $("#userSearchForm").serializeObjectNoNullAttr());
}
//重置
function reset(){
    $("#userSearchForm").form("reset");
}