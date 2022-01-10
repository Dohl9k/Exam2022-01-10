import java.awt.Color
import java.awt.Dimension
import javax.swing.*
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener

class MainFrame : JFrame() {
    val mainPanel: GraphicsPanel
    val controlPanel: JPanel
    val plane: Plane

    val xMin: JSpinner
    val xMinM: SpinnerNumberModel
    val xMax: JSpinner
    val xMaxM: SpinnerNumberModel
    val yMin: JSpinner
    val yMinM: SpinnerNumberModel
    val yMax: JSpinner
    val yMaxM: SpinnerNumberModel
    val x_val: JSpinner
    val x_valM: SpinnerNumberModel
    val t_val: JSpinner
    val t_valM: SpinnerNumberModel

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        minimumSize = Dimension(800, 600)
        xMinM = SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1)
        xMin = JSpinner(xMinM)
        xMaxM = SpinnerNumberModel(5.0, -4.9, 100.0, 0.1)
        xMax = JSpinner(xMaxM)
        yMinM = SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1)
        yMin = JSpinner(yMinM)
        yMaxM = SpinnerNumberModel(5.0, -4.9, 100.0, 0.1)
        yMax = JSpinner(yMaxM)
        x_valM = SpinnerNumberModel(15.0, -4.9, 100.0, 0.1)
        x_val = JSpinner(x_valM)
        t_valM = SpinnerNumberModel(10.0, -4.9, 100.0, 0.1)
        t_val = JSpinner(t_valM)
        plane = Plane(
            xMin.value as Double,
            xMax.value as Double,
            yMin.value as Double,
            yMax.value as Double
        )
        mainPanel = GraphicsPanel().apply {
            background = Color.WHITE
        }

        controlPanel = JPanel().apply {
            background = Color.CYAN
        }
        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(
                                mainPanel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE
                            )
                            .addComponent(
                                controlPanel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE
                            )
                    )
                    .addGap(4)
            )

            setVerticalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addComponent(
                        mainPanel,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE
                    )
                    .addGap(4)
                    .addComponent(
                        controlPanel,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(4)
            )
        }



        /*xMax.addChangeListener(object : ChangeListener{
            override fun stateChanged(e: ChangeEvent?) {
                TODO("Not yet implemented")
            }
        })*/
        xMin.addChangeListener {
            xMaxM.minimum = xMin.value as Double + 0.1
            repaint()
        }
        xMax.addChangeListener {
            xMinM.maximum = xMax.value as Double - 0.1
            repaint()}
        yMin.addChangeListener {
            yMaxM.minimum = yMin.value as Double + 0.1
            repaint()}
        yMax.addChangeListener {
            yMinM.maximum = yMax.value as Double - 0.1
            repaint()}

        controlPanel.layout = GroupLayout(controlPanel).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMin, 100, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMin, 100, 100, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(8)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(xMax, 100, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yMax, 100, 100, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(8)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(x_val, 100, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_val, 100, 100, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGap(4, 4, Int.MAX_VALUE)
            )
            setVerticalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(
                                xMin,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                            .addComponent(
                                xMax,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                            .addComponent(
                                x_val,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                    )
                    .addGap(8)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(
                                yMin,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                            .addComponent(
                                yMax,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                            .addComponent(
                                t_val,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.PREFERRED_SIZE
                            )
                    )
                    .addGap(4, 4, Int.MAX_VALUE)
            )
        }
    }
}
