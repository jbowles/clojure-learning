;;;; Small swing app

(import '(javax.swing JFrame JLabel JTextField JButton)
        '(java.awt.event ActionListener)
        '(java.awt GridLayout))

(defn celsius []
  (let [frame (JFrame. "Celsius Converter")
        temp-text (JTextField.)
        celsius-label (JLabel. "Celsius")
        convert-button (JButton. "Convert")
        farenheit-label (JLabel. "Farenheit")]
    (.addActionListener convert-button
                        (proxy [ActionListener] []
                          (actionPerformed [evt]
                            (let [c (Double/parseDouble (.getText temp-text))]
                              (.setText farenheit-label
                                        (str (+ 32 (* 1.8 c)) " Farenheit"))))))
    (doto frame
      (.setLayout (GridLayout. 2 2 3 3))
      (.add temp-text)
      (.add celsius-label)
      (.add convert-button)
      (.add farenheit-label)
      (.setSize 300 80)
      (.setVisible true))))

;(celsius)


(defn kilometer []
  (let [frame (JFrame. "Kilometer Converter")
        temp-text (JTextField.)
        kilo-label (JLabel. "Kilometers")
        convert-button (JButton. "Convert")
        mile-label (JLabel. "Miles")]
    (.addActionListener convert-button
                        (proxy [ActionListener] []
                          (actionPerformed [evt]
                            (let [k (Double/parseDouble (.getText temp-text))]
                              (.setText mile-label
                                        (str (* 0.6 k) " Miles"))))))
    (doto frame
      (.setLayout (GridLayout. 2 2 3 3))
      (.add temp-text)
      (.add kilo-label)
      (.add convert-button)
      (.add mile-label)
      (.setSize 300 80)
      (.setVisible true))))

(kilometer)

(defn grade []
  (let [frame (JFrame. "Grade Calculator (in feet)")
        rise-text (JTextField.)
        rise-label (JLabel. "Rise (elevation increase)")
        run-text (JTextField.)
        run-label (JLabel. "Run (distance traveled)")
        calculate-button (JButton. "Calculate")
        grade-label (JLabel. "Calculate... ")
        description-label (JLabel. "Grade is rise divided by run (in feet).")]
    (.addActionListener calculate-button
                        (proxy [ActionListener] []
                          (actionPerformed [evt]
                            (let [rise (Double/parseDouble (.getText rise-text)) 
                                  run (Double/parseDouble (.getText run-text))]
                              (.setText grade-label
                                        (str (format "%.3f" (* (/ rise run )100)) "% Grade"))))))
    (doto frame
      (.setLayout (GridLayout. 5 2 2 2))
      (.add rise-text)
      (.add rise-label)
      (.add run-text)
      (.add run-label)
      (.add grade-label)
      (.add calculate-button)
      (.add description-label)
      (.setSize 550 250)
      (.setVisible true))))

(grade)
