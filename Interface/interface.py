from PyQt5 import uic
from PyQt5.QtWidgets import *

class UI(QMainWindow):
    def __init__(self):
        super(UI, self).__init__()

        uic.loadUi("main.ui", self)
        # link to UI widgets
        self.input_sql = self.findChild(QTextEdit, "input_query")
        self.label_qep = self.findChild(QLabel, "text_plan")
        self.btn_analyse = self.findChild(QPushButton, "btn_analyse")
        self.btn_clear = self.findChild(QPushButton, "btn_clear")
        self.list_database = self.findChild(QComboBox, "combo_databases")
        self.tree_attrs = self.findChild(QTreeWidget, "tree_attrs")
        # init widgets
        self.tree_attrs.setHeaderLabels(["Schema"])
        self.btn_clear.clicked.connect(self.clear)
        self.list_database.currentIndexChanged.connect(self._onDatabaseChanged)
        self.tree_attrs.itemDoubleClicked.connect(self._onSchemaItemDoubleClicked)

    def showError(self, errMessage, execption=None):
        dialog = QMessageBox()
        dialog.setStyleSheet("QLabel{min-width: 300px;}")
        dialog.setWindowTitle("Error")
        #dialog.setIcon(QMessageBox.Warning)
        dialog.setText(errMessage)
        if execption is not None:
            dialog.setDetailedText(str(execption))
        dialog.setStandardButtons(QMessageBox.Ok)
        #dialog.buttonClicked.connect(cb)
        dialog.exec_()

    def clear(self):
        self.input_sql.setPlainText("")
        self.label_qep.setText("")
        
    def readInput(self):
        return self.input_sql.toPlainText()
    
    def setInput(self, text):
        self.input_sql.setPlainText(text)
    
    def setResult(self, text):
        self.label_qep.setText(text)
            
    def setSchema(self, schema=None):
        self.tree_attrs.clear()
        if schema is None:
            return
        for table in schema:
            table_item = QTreeWidgetItem([table])
            for attr in schema[table]:
                attr_item =  QTreeWidgetItem([attr])
                table_item.addChild(attr_item)  
            self.tree_attrs.addTopLevelItem(table_item)
            
    # callback setter
    def setOnAnalyseClicked(self, callback):
        if callback:
            self.btn_analyse.clicked.connect(callback)
        
    def setOnDatabaseChanged(self, callback):
        self.cb_db_changed = callback
        
    def setListDatabase(self, list_db=["TPC-H"]):
        self.list_database.clear()
        self.list_database.addItems(list_db)

            
    # private events handling 
    def _onDatabaseChanged(self):
        if hasattr(self, "cb_db_changed"):
            self.cb_db_changed()
        
    def _onSchemaItemDoubleClicked(self, item, col):
        # append item text to input text area
        self.setInput( f"{self.readInput()} {item.text(col)} ") 