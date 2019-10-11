import org.openrndr.Fullscreen
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.math.Vector2
import org.openrndr.shape.contour

fun main() = application {
    configure {
        fullscreen = Fullscreen.CURRENT_DISPLAY_MODE
        width = 1920
        height = 1200
    }

    program {
        val mixerBuffer = colorBuffer(width, height)
        val feedbackShader = Filter(null, filterWatcherFromUrl("file:src/main/glsl/feedback.frag"))
        feedbackShader.parameters["resolution"] = Vector2(width.toDouble(), height.toDouble())
        extend {
            feedbackShader.apply(mixerBuffer, mixerBuffer)
            drawer.image(mixerBuffer)
        }
    }
}