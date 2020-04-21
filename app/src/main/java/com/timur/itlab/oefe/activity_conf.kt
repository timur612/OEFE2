package com.timur.itlab.oefe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.vidyo.VidyoClient.Connector.Connector
import com.vidyo.VidyoClient.Connector.ConnectorPkg

class activity_conf : AppCompatActivity(), Connector.IConnect {


    lateinit var vc:Connector
    lateinit var videoFrame:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conf)

        ConnectorPkg.setApplicationUIContext(this)
        ConnectorPkg.initialize()

        videoFrame = findViewById(R.id.videoFrame)


    }

    fun Start(v: View){
        vc = Connector(videoFrame,Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default,16,"","",0)
        vc.showViewAt(videoFrame,0,0,videoFrame.width,videoFrame.height)
    }
    fun Connect(v: View){
        val token:String = "cHJvdmlzaW9uAHVzZXIxQDc2ZWY4NC52aWR5by5pbwA2Mzc1NDY4NTI0MgAAZTk3MmI0OWJlNzJhMzkyNWRlMTc3YTViYjkwODlkOWQ5YjQzMGI5ODhmNzBhNzU3NWNmMmY3NGNmNTc4ZGMwYTg4ZjMyYmJkOTIyOWZhMjlmMDM1ZGEwNTgxNzI5ZWY4"
        vc.connect("prod.vidyo.io",token,"DemoUser","DemoRoom",this)

    }
    fun Disconnect(v:View){
        vc.disconnect()
    }
    override fun onDisconnected(p0: Connector.ConnectorDisconnectReason?) {
         //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(p0: Connector.ConnectorFailReason?) {
         //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
         //To change body of created functions use File | Settings | File Templates.
    }
}
