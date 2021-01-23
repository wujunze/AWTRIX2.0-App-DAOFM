B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=4.2
@EndOfDesignText@

Sub Class_Globals
	Dim App As AWTRIX
	
	'Declare your variables here
	Dim scroll As Int
	Dim fans As String ="0"
	Dim nums As String ="0"
End Sub

' ignore
public Sub GetNiceName() As String
	Return App.Name
End Sub

' ignore
public Sub Run(Tag As String, Params As Map) As Object
	Return App.interface(Tag,Params)
End Sub

' Config your App
Public Sub Initialize() As String
	
	App.Initialize(Me,"App")
	
	'App name (must be unique, avoid spaces)
	App.name="DAOFM"
	
	'Version of the App
	App.version="1.0"
	
	'Description of the App. You can use HTML to format it
	App.description="Shows your DAOFM fans and total play count number"

	App.author="Panda"

	App.coverIcon = 1296

	'How many downloadhandlers should be generated
	App.Downloads=1

	'IconIDs from AWTRIXER. You can add multiple if you want to display them at the same time
	App.icons=Array As Int(1295,1296)


	'Tickinterval in ms (should be 65 by default, for smooth scrolling))
	App.tick=65

	App.MakeSettings
	Return "AWTRIX20"
End Sub

Sub App_Started
	scroll=1
End Sub

'Called with every update from Awtrix
'return one URL for each downloadhandler
Sub App_startDownload(jobNr As Int)
	Select jobNr
		Case 1
			App.Download("https://apis.daopub.com/api/rtd/screen_data/")
	End Select

End Sub

Sub App_evalJobResponse(Resp As JobResponse)
	Try
		If Resp.success Then
			Select Resp.jobNr
				Case 1
					Dim parser As JSONParser
					parser.Initialize(Resp.ResponseString)
					Dim root As Map = parser.NextObject
					fans = root.Get("unique_user")
					nums = root.Get("play_count")
			End Select
		End If
	Catch
		Log("Error in: "& App.Name & CRLF & LastException)
		Log("API response: " & CRLF & Resp.ResponseString)
	End Try
End Sub

'With this sub you build your frame.
Sub App_genFrame
	If App.startedAt<DateTime.Now-App.duration*1000/2 Then
		App.genText(nums,True,scroll,Null,False)
		App.drawBMP(0,scroll-1,App.getIcon(1296),8,8)
		If scroll<9 Then
			scroll=scroll+1
		Else
			App.genText(fans,True,scroll-8,Null,False)
			App.drawBMP(0,scroll-9,App.getIcon(1295),8,8)
		End If
	Else
		App.genText(nums,True,1,Null,False)
		App.drawBMP(0,0,App.getIcon(1296),8,8)
	End If
End Sub