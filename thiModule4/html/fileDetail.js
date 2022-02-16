function getParam(){
    // var url_string = "http://www.example.com/t.html?a=1&b=3&c=m2-m3-m4-m5"; //window.location.href
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    console.log(id);
    return id;
}
function showDetail(){
    let id = getParam();
    console.log(id)
    $.ajax({
        type:"GET",
        url: `http://localhost:8080/cities/${id}`,
        success:function (data){
            let str="";

            str+=`<tr><h1>Thành phố ${data.name}</h1></tr>`
            str+=`<tr><p>Tên : ${data.name} </p></tr>`
            str+=`<tr><p>Quốc Gia : ${data.quocGia.tenQuocGia} </p></tr>`
            str+=`<tr><p>Diện Tích : ${data.dienTich} </p></tr>`
            str+=`<tr><p>Dân Số : ${data.danSo} </p></tr>`
            str+=`<tr><p>GDP : ${data.gdp} </p></tr>`
            str+=`<tr><p>Giới THiệu :${data.gioiThieu}  </p></tr>`
            str+=`<td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModalDetailForm" onclick="showFormDelete(${data.id})">Delete</button></td>`
            str+=`<tr><button type="button" class="btn btn-warning" onclick="showFormEdit(${data.id})" data-toggle="modal" data-target="#myModalEdit">Edit</button></tr>`

            document.getElementById("detail").innerHTML = str
        }

        ,error:function (err){
            console.log(err)
        }
    })
}
showDetail();
function showFormEdit(id){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/cities/"+id,
        success: function (data){
            document.getElementById("nameEdit").value = data.name;
            document.getElementById("idEdit").value = data.id;
            document.getElementById("dansoEdit").value = data.danSo;
            document.getElementById("GDPEdit").value = data.gdp ;
            document.getElementById("gioithieuEdit").value = data.gioiThieu;
            document.getElementById("dienTichEdit").value = data.dienTich;
            document.getElementById("quocgiaEdit").value = data.quocGia.id;
        }
    })
}
function edit(){

    let name = document.getElementById("nameEdit").value;
    let id = document.getElementById("idEdit").value;
    let quocgia = document.getElementById("quocgiaEdit").value;
    let dientich = document.getElementById("dansoEdit").value;
    let danso = document.getElementById("dansoEdit").value;
    let gdp = document.getElementById("GDPEdit").value;
    let gioithieu = document.getElementById("gioithieuEdit").value;

    let product = {
        id:id,
        name: name,
        gioiThieu : gioithieu,
        dienTich : dientich,
        danSo :danso,
        gdp : gdp,
        quocGia : {id:quocgia}
    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/cities",
        data : JSON.stringify(product),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success : function (){
            window.open("index.html","_self")
        },
        error:function (err){
            document.getElementById("errEdit").innerText = "Edit Fail"
        }
    })
}
function deletee(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/cities/"+id,
        success : function (){
            window.open("index.html","_self")
        }
    })
}
function showQuocGia(){
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/quocgia",
        success:function (data){
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += `<option value="${data[i].id}">${data[i].tenQuocGia}</option>`
            }

            document.getElementById("quocgiaEdit").innerHTML = str;
        }

    })
}
showQuocGia()
function showFormDelete(idDelete){
    console.log(idDelete)
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/cities/"+idDelete,
        success: function (data){
            let str="";
            str+=`<div class="modal fade" id="deleteModalDetailForm" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="deleteTP"> Xóa thành phố ${data.name}</h4>
                </div>
                <div class="modal-body">
                    <h1>Xóa thành phố</h1>
                    <div id="confimDelete">Bạn có chắc chắn muốn xóa thành phố :  ${data.name}</div>

                </div>
                <div class="modal-footer">
                    <button type="button" onclick="deletee(${data.id})" >Delete</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>`
            document.getElementById("strDeleteModalDetail").innerHTML = str;
        }
        ,error:function (err){
            console.log(err)
        }
    })
}