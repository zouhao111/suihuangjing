function pdf()
{


var html=$("#pdf").html();
var name=$("#com_name").html();



 var a = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body><div  style='background:url(resources/img/logoo.png);'>"
  var z = "</div></body></html>"
  var html1=a+name+html+z
//XDoc.run("http://localhost:8089/tdhtv2.0/admin/tdht/waterForm/waterFormList?rid=75501330001&type=1", "pdf");
XDoc.run(html1, "s.pdf");

}