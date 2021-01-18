package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class neteasemusic extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.neteasemusic", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.neteasemusic.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.awtrix _app = null;
public int _scroll = 0;
public String _fans = "";
public String _nums = "";
public String  _app_evaljobresponse(b4j.example.awtrix._jobresponse _resp) throws Exception{
anywheresoftware.b4j.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
 //BA.debugLineNum = 80;BA.debugLine="Sub App_evalJobResponse(Resp As JobResponse)";
 //BA.debugLineNum = 81;BA.debugLine="Try";
try { //BA.debugLineNum = 82;BA.debugLine="If Resp.success Then";
if (_resp.Success /*boolean*/ ) { 
 //BA.debugLineNum = 83;BA.debugLine="Select Resp.jobNr";
switch (BA.switchObjectToInt(_resp.jobNr /*int*/ ,(int) (1))) {
case 0: {
 //BA.debugLineNum = 85;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 86;BA.debugLine="parser.Initialize(Resp.ResponseString)";
_parser.Initialize(_resp.ResponseString /*String*/ );
 //BA.debugLineNum = 87;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 88;BA.debugLine="fans = root.Get(\"unique_user\")";
_fans = BA.ObjectToString(_root.Get((Object)("unique_user")));
 //BA.debugLineNum = 89;BA.debugLine="nums = root.Get(\"play_count\")";
_nums = BA.ObjectToString(_root.Get((Object)("play_count")));
 break; }
}
;
 };
 } 
       catch (Exception e13) {
			ba.setLastException(e13); //BA.debugLineNum = 93;BA.debugLine="Log(\"Error in: \"& App.Name & CRLF & LastExceptio";
__c.Log("Error in: "+_app._getname /*String*/ ()+__c.CRLF+BA.ObjectToString(__c.LastException(ba)));
 //BA.debugLineNum = 94;BA.debugLine="Log(\"API response: \" & CRLF & Resp.ResponseStrin";
__c.Log("API response: "+__c.CRLF+_resp.ResponseString /*String*/ );
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _app_genframe() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub App_genFrame";
 //BA.debugLineNum = 100;BA.debugLine="If App.startedAt<DateTime.Now-App.duration*1000/2";
if (_app._getstartedat /*long*/ ()<__c.DateTime.getNow()-_app._getduration /*int*/ ()*1000/(double)2) { 
 //BA.debugLineNum = 101;BA.debugLine="App.genText(nums,True,scroll,Null,False)";
_app._gentext /*String*/ (_nums,__c.True,_scroll,(int[])(__c.Null),__c.False);
 //BA.debugLineNum = 102;BA.debugLine="App.drawBMP(0,scroll-1,App.getIcon(1296),8,8)";
_app._drawbmp /*String*/ ((int) (0),(int) (_scroll-1),_app._geticon /*short[]*/ ((int) (1296)),(int) (8),(int) (8));
 //BA.debugLineNum = 103;BA.debugLine="If scroll<9 Then";
if (_scroll<9) { 
 //BA.debugLineNum = 104;BA.debugLine="scroll=scroll+1";
_scroll = (int) (_scroll+1);
 }else {
 //BA.debugLineNum = 106;BA.debugLine="App.genText(fans,True,scroll-8,Null,False)";
_app._gentext /*String*/ (_fans,__c.True,(int) (_scroll-8),(int[])(__c.Null),__c.False);
 //BA.debugLineNum = 107;BA.debugLine="App.drawBMP(0,scroll-9,App.getIcon(1295),8,8)";
_app._drawbmp /*String*/ ((int) (0),(int) (_scroll-9),_app._geticon /*short[]*/ ((int) (1295)),(int) (8),(int) (8));
 };
 }else {
 //BA.debugLineNum = 110;BA.debugLine="App.genText(nums,True,1,Null,False)";
_app._gentext /*String*/ (_nums,__c.True,(int) (1),(int[])(__c.Null),__c.False);
 //BA.debugLineNum = 111;BA.debugLine="App.drawBMP(0,0,App.getIcon(1296),8,8)";
_app._drawbmp /*String*/ ((int) (0),(int) (0),_app._geticon /*short[]*/ ((int) (1296)),(int) (8),(int) (8));
 };
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public String  _app_startdownload(int _jobnr) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub App_startDownload(jobNr As Int)";
 //BA.debugLineNum = 73;BA.debugLine="Select jobNr";
switch (_jobnr) {
case 1: {
 //BA.debugLineNum = 75;BA.debugLine="App.Download(\"https://apis.daopub.com/api/rtd/s";
_app._download /*String*/ ("https://apis.daopub.com/api/rtd/screen_data/"+BA.ObjectToString(_app._get /*Object*/ ("MID")));
 break; }
}
;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _app_started() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub App_Started";
 //BA.debugLineNum = 67;BA.debugLine="scroll=1";
_scroll = (int) (1);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim App As AWTRIX";
_app = new b4j.example.awtrix();
 //BA.debugLineNum = 6;BA.debugLine="Dim scroll As Int";
_scroll = 0;
 //BA.debugLineNum = 7;BA.debugLine="Dim fans As String =\"0\"";
_fans = "0";
 //BA.debugLineNum = 8;BA.debugLine="Dim nums As String =\"0\"";
_nums = "0";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public String  _getnicename() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="public Sub GetNiceName() As String";
 //BA.debugLineNum = 13;BA.debugLine="Return App.Name";
if (true) return _app._getname /*String*/ ();
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Initialize() As String";
 //BA.debugLineNum = 24;BA.debugLine="App.Initialize(Me,\"App\")";
_app._initialize /*String*/ (ba,this,"App");
 //BA.debugLineNum = 27;BA.debugLine="App.name=\"DAOFM\"";
_app._setname /*String*/ ("DAOFM");
 //BA.debugLineNum = 30;BA.debugLine="App.version=\"1.0\"";
_app._setversion /*String*/ ("1.0");
 //BA.debugLineNum = 33;BA.debugLine="App.description=\"Shows your DAOFM fans and total";
_app._setdescription /*String*/ ("Shows your DAOFM fans and total play count number");
 //BA.debugLineNum = 35;BA.debugLine="App.author=\"Panda\"";
_app._setauthor /*String*/ ("Panda");
 //BA.debugLineNum = 37;BA.debugLine="App.coverIcon = 1296";
_app._setcovericon((int) (1296));
 //BA.debugLineNum = 40;BA.debugLine="App.Downloads=1";
_app._setdownloads((int) (1));
 //BA.debugLineNum = 43;BA.debugLine="App.setupDescription= $\" 		<b>MID:</b>     <ul>";
_app._setsetupdescription(("\n"+"		<b>MID:</b>\n"+"    <ul>\n"+"		<li>Go to https://music.163.com/</li>\n"+"		<li>Login your Netease Music and go to personal page</li>\n"+"		<li>and url will be https://music.163.com/#/user/home?id=XXXXXXX</li>\n"+"		<li>XXXXXXX is your MID</li><br/><br/>\n"+"	</ul>\n"+"	"));
 //BA.debugLineNum = 54;BA.debugLine="App.icons=Array As Int(1295,1296)";
_app._seticons(anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (1295),(int) (1296)}));
 //BA.debugLineNum = 57;BA.debugLine="App.Settings=CreateMap(\"MID\":\"\")";
_app._setsettings(__c.createMap(new Object[] {(Object)("MID"),(Object)("")}));
 //BA.debugLineNum = 60;BA.debugLine="App.tick=65";
_app._settick /*String*/ (BA.NumberToString(65));
 //BA.debugLineNum = 62;BA.debugLine="App.MakeSettings";
_app._makesettings /*String*/ ();
 //BA.debugLineNum = 63;BA.debugLine="Return \"AWTRIX20\"";
if (true) return "AWTRIX20";
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public Object  _run(String _tag,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="public Sub Run(Tag As String, Params As Map) As Ob";
 //BA.debugLineNum = 18;BA.debugLine="Return App.interface(Tag,Params)";
if (true) return _app._interface /*Object*/ (_tag,_params);
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
