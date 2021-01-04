$(function () {

    /*查询所有书类型*/
    function findAll(){
        $.get("/booktype/queryAll",function (response) {
            if(response.status ==20000){
                var str="";
                response.data.forEach(i => {
                    str +=`<tr>
                                <td>${i.typeId}</td>
                                <td>${i.typeName}</td>
                                <td>${i.parentId}</td>
                                <td>
                                    <button class="btn btn-sm  btn-info" data-toggle="modal"
                                            data-target="#modal-default">
                                        编辑
                                    </button>
                                    <button class="btn btn-sm  btn-warning" data-toggle="modal" data-target="#delModal">
                                        删除
                                    </button>
                                </td>
                            </tr>`;
                })
                $("tbody").html(str)
            };

        })
    }

    findAll()

})
