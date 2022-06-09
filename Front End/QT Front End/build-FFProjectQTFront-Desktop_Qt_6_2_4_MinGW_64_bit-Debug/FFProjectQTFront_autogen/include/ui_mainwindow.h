/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.2.4
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPlainTextEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QHBoxLayout *horizontalLayout;
    QTabWidget *mainTabWidget;
    QWidget *ingestTab;
    QVBoxLayout *verticalLayout_2;
    QHBoxLayout *horizontalLayout_2;
    QLabel *label;
    QComboBox *statsTypeDB;
    QLabel *label_2;
    QLineEdit *yearEdit;
    QLabel *label_3;
    QLineEdit *fileNameEdit;
    QPushButton *fileBrowserBtn;
    QPushButton *ingestBtn;
    QHBoxLayout *horizontalLayout_3;
    QPlainTextEdit *ingestConsole;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(813, 528);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        horizontalLayout = new QHBoxLayout(centralwidget);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        mainTabWidget = new QTabWidget(centralwidget);
        mainTabWidget->setObjectName(QString::fromUtf8("mainTabWidget"));
        ingestTab = new QWidget();
        ingestTab->setObjectName(QString::fromUtf8("ingestTab"));
        verticalLayout_2 = new QVBoxLayout(ingestTab);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        label = new QLabel(ingestTab);
        label->setObjectName(QString::fromUtf8("label"));

        horizontalLayout_2->addWidget(label);

        statsTypeDB = new QComboBox(ingestTab);
        statsTypeDB->addItem(QString());
        statsTypeDB->addItem(QString());
        statsTypeDB->addItem(QString());
        statsTypeDB->setObjectName(QString::fromUtf8("statsTypeDB"));

        horizontalLayout_2->addWidget(statsTypeDB);

        label_2 = new QLabel(ingestTab);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        horizontalLayout_2->addWidget(label_2);

        yearEdit = new QLineEdit(ingestTab);
        yearEdit->setObjectName(QString::fromUtf8("yearEdit"));

        horizontalLayout_2->addWidget(yearEdit);

        label_3 = new QLabel(ingestTab);
        label_3->setObjectName(QString::fromUtf8("label_3"));

        horizontalLayout_2->addWidget(label_3);

        fileNameEdit = new QLineEdit(ingestTab);
        fileNameEdit->setObjectName(QString::fromUtf8("fileNameEdit"));

        horizontalLayout_2->addWidget(fileNameEdit);

        fileBrowserBtn = new QPushButton(ingestTab);
        fileBrowserBtn->setObjectName(QString::fromUtf8("fileBrowserBtn"));

        horizontalLayout_2->addWidget(fileBrowserBtn);


        verticalLayout_2->addLayout(horizontalLayout_2);

        ingestBtn = new QPushButton(ingestTab);
        ingestBtn->setObjectName(QString::fromUtf8("ingestBtn"));

        verticalLayout_2->addWidget(ingestBtn);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3->setObjectName(QString::fromUtf8("horizontalLayout_3"));
        ingestConsole = new QPlainTextEdit(ingestTab);
        ingestConsole->setObjectName(QString::fromUtf8("ingestConsole"));

        horizontalLayout_3->addWidget(ingestConsole);


        verticalLayout_2->addLayout(horizontalLayout_3);

        mainTabWidget->addTab(ingestTab, QString());

        horizontalLayout->addWidget(mainTabWidget);

        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 813, 21));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        mainTabWidget->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "Ingest", nullptr));
        statsTypeDB->setItemText(0, QCoreApplication::translate("MainWindow", "rushing stats", nullptr));
        statsTypeDB->setItemText(1, QCoreApplication::translate("MainWindow", "passing stats", nullptr));
        statsTypeDB->setItemText(2, QCoreApplication::translate("MainWindow", "receiving stats", nullptr));

        label_2->setText(QCoreApplication::translate("MainWindow", "for the year", nullptr));
        label_3->setText(QCoreApplication::translate("MainWindow", "using", nullptr));
        fileBrowserBtn->setText(QCoreApplication::translate("MainWindow", "File Browser", nullptr));
        ingestBtn->setText(QCoreApplication::translate("MainWindow", "Send to DB", nullptr));
        mainTabWidget->setTabText(mainTabWidget->indexOf(ingestTab), QCoreApplication::translate("MainWindow", "Ingest Data", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
