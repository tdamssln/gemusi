<link rel="stylesheet" type="text/css" href="${requestContext.contextPath}/static/jquery-easyui-1.6.11/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${requestContext.contextPath}/static/jquery-easyui-1.6.11/themes/icon.css">
	<script type="text/javascript" src="${requestContext.contextPath}/static/jquery-easyui-1.6.11/jquery.min.js"></script>
	<script type="text/javascript" src="${requestContext.contextPath}/static/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${requestContext.contextPath}/static/js/common.js"></script>
<script type="text/javascript" src="${requestContext.contextPath}/static/js/system/user/user.js"></script>

<div class="search-box">
    <form id="userSearchForm"  method="post">
        <table class="table_content"   border="0" >
            <tr>
                <td class="tar" >姓名：</td>
                <td class="tal" >
                    <input class="easyui-textbox" name="userInfo.username" prompt="模糊查询"/>
                </td>
                <td class="tar" >邮箱：</td>
                <td class="tal" >
                    <input class="easyui-textbox" name="userInfo.email" prompt=""/>
                </td>
                <td class="tar" >手机号：</td>
                <td class="tal" >
                    <input class="easyui-textbox" name="userInfo.mobile" prompt=""/>
                </td>
                <td style="padding-left:20px">
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="doSearch()">搜索</a>
                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px" onclick="reset()">重置</a>
                </td>
            </tr>
        </table>
    </form>
</div>

<div class="box-table">
    <div class="table-btn-box">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">增加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="reload()">刷新</a>
    </div>
    <table id="userTable" style="width:100%"></table>
</div>