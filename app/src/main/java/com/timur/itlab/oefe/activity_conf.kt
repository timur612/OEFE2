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
        val token:String = "cHJvdmlzaW9uAHVzZXIxQDc2ZWY4NC52aWR5by5pbwA2Mzc1NDY4OTA3OAAAY2ViNDM1M2Q3NjVlMzExODMyYzU1OTdhZTU2YzZmMmNlYjY4Y2MxYTYzZjQ1OGJlOWQ0ZTY1ZTlmYzFlNjA5YzRlYzI4Y2JmODdiNWYyZmYzYTBlMTc4Njg3ODU5MjQ3"
        vc.connect("prod.vidyo.io",token,"DemoUser","DemoRoom",this)

    }
    fun Disconnect(v:View){
        vc.disconnect()
    }
    override fun onDisconnected(p0: Connector.ConnectorDisconnectReason?) {

    }

    override fun onFailure(p0: Connector.ConnectorFailReason?) {

    }

    override fun onSuccess() {

    }
}
