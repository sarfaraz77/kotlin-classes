import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice protected constructor ( val name: String, val category: String) {
   
    var deviceStatus = "Online"
        protected set
    open val deviceType = "Unknown"
    
    open fun turnOn() {
        deviceStatus = "On"
        println("$name = $deviceStatus")
    }
    open fun turnOff() {
        deviceStatus = "Off"
        println("$name = $deviceStatus")
    }
    fun printDeviceInfo() {
        println("Name: $name, category: $category, type: $deviceType")
    }    
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    
    private var speakerVolume by RangeRegulator(initialValue = 5, minValue = 0, maxValue = 100)
    
    private var channelNumber by RangeRegulator(initialValue = 24, minValue = 1, maxValue = 200)
    
    override val deviceType = "Smart TV"
    
    fun increaseVolume() {
        speakerVolume++
        println("Speaker volume set to $speakerVolume")
    }
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume is set to $speakerVolume")
    }
    
    fun nextChannel() {
        channelNumber++
        println("Channel set to $channelNumber")
    }
    fun previousChannel() {
        channelNumber--
        println("Channel set to $channelNumber")
    }
    
    override fun turnOn() {
        super.turnOn()
        println("$name is turned on, the volume is $speakerVolume and channel is $channelNumber")
    }
    override fun turnOff() {
        super.turnOff()
        println("$name is turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    
    override val deviceType = "Smart Light"
    
        
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness level set to $brightnessLevel")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness level set to $brightnessLevel")
    }
    
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 10
        println("$name is turned on, brightness is set to $brightnessLevel")
    }
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name is turned off.")
    }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice : SmartLightDevice
) {
//     Smart TV
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume() {
        smartTvDevice.increaseVolume()
    }
    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }
    
//     Smart Light
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }
    fun turnOffAllDevice() {
        turnOffTv()
        turnOffLight()
    }
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }
    
    var deviceTurnOnCount = 0
        private set
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {   
    var tv = SmartTvDevice("LG Android Tv", "Entertainment")
    var light = SmartLightDevice("Wipro Light", "Utility")
    
    var home = SmartHome(tv,light)
    home.turnOnTv()
    home.increaseTvVolume()
    home.decreaseTvVolume()
    home.changeTvChannelToNext()
    home.changeTvChannelToPrevious()
    home.printSmartTvInfo()
    
    home.turnOnLight()
    home.increaseLightBrightness()
    home.decreaseLightBrightness()
    home.printSmartLightInfo()
    
}