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

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Урок Математика"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        ConnectorPkg.setApplicationUIContext(this)
        ConnectorPkg.initialize()

        videoFrame = findViewById(R.id.videoFrame)


    }

    fun Start(v: View){
        vc = Connector(videoFrame,Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default,16,"","",0)
        vc.showViewAt(videoFrame,0,0,videoFrame.width,videoFrame.height)
    }
    fun Connect(v: View){
        val token:String = "cHJvdmlzaW9uAHVzZXIxQDc2ZWY4NC52aWR5by5pbwA2Mzc1NDkyMjM0OQAAYmE5MDdkYjE4NzM3MGIzZGFiN2Q4NWRiNjhmN2FlZTg1NTIxMWQ5NGZmNDExNzM3OGYyMWRmM2QwZDQ5YTkzM2UyYTNmMTBiY2UwM2QyNmQyODQ5ZTU5MzRhZGUxODIz"
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
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
