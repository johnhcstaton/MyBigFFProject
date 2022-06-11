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
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPlainTextEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QTableWidget>
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
    QHBoxLayout *ingestLayout1;
    QLabel *ingestLbl;
    QComboBox *statsTypeDB;
    QLabel *ingestForTheYearLbl;
    QLineEdit *yearEdit;
    QLabel *ingestUsingLbl;
    QLineEdit *fileNameEdit;
    QPushButton *fileBrowserBtn;
    QPushButton *ingestBtn;
    QPlainTextEdit *ingestConsole;
    QWidget *viewDataTab;
    QVBoxLayout *verticalLayout_3;
    QHBoxLayout *viewDataLayout;
    QComboBox *statsCB;
    QComboBox *yearCB;
    QPushButton *refreshBtn;
    QTableWidget *viewDataTbl;
    QWidget *playerCompTab;
    QVBoxLayout *verticalLayout_6;
    QHBoxLayout *horizontalLayout_6;
    QLabel *playerCompPositionLbl;
    QComboBox *playerCompPositionCb;
    QHBoxLayout *horizontalLayout_4;
    QLabel *playerCompPlayerSelectLbl;
    QComboBox *playerCompPlayerSelectCb;
    QPushButton *findCompBtn;
    QHBoxLayout *horizontalLayout_5;
    QVBoxLayout *verticalLayout_7;
    QSpacerItem *verticalSpacer;
    QVBoxLayout *verticalLayout_9;
    QSpacerItem *verticalSpacer_2;
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
        ingestLayout1 = new QHBoxLayout();
        ingestLayout1->setObjectName(QString::fromUtf8("ingestLayout1"));
        ingestLbl = new QLabel(ingestTab);
        ingestLbl->setObjectName(QString::fromUtf8("ingestLbl"));

        ingestLayout1->addWidget(ingestLbl);

        statsTypeDB = new QComboBox(ingestTab);
        statsTypeDB->addItem(QString());
        statsTypeDB->addItem(QString());
        statsTypeDB->addItem(QString());
        statsTypeDB->setObjectName(QString::fromUtf8("statsTypeDB"));

        ingestLayout1->addWidget(statsTypeDB);

        ingestForTheYearLbl = new QLabel(ingestTab);
        ingestForTheYearLbl->setObjectName(QString::fromUtf8("ingestForTheYearLbl"));

        ingestLayout1->addWidget(ingestForTheYearLbl);

        yearEdit = new QLineEdit(ingestTab);
        yearEdit->setObjectName(QString::fromUtf8("yearEdit"));

        ingestLayout1->addWidget(yearEdit);

        ingestUsingLbl = new QLabel(ingestTab);
        ingestUsingLbl->setObjectName(QString::fromUtf8("ingestUsingLbl"));

        ingestLayout1->addWidget(ingestUsingLbl);

        fileNameEdit = new QLineEdit(ingestTab);
        fileNameEdit->setObjectName(QString::fromUtf8("fileNameEdit"));

        ingestLayout1->addWidget(fileNameEdit);

        fileBrowserBtn = new QPushButton(ingestTab);
        fileBrowserBtn->setObjectName(QString::fromUtf8("fileBrowserBtn"));

        ingestLayout1->addWidget(fileBrowserBtn);


        verticalLayout_2->addLayout(ingestLayout1);

        ingestBtn = new QPushButton(ingestTab);
        ingestBtn->setObjectName(QString::fromUtf8("ingestBtn"));

        verticalLayout_2->addWidget(ingestBtn);

        ingestConsole = new QPlainTextEdit(ingestTab);
        ingestConsole->setObjectName(QString::fromUtf8("ingestConsole"));

        verticalLayout_2->addWidget(ingestConsole);

        mainTabWidget->addTab(ingestTab, QString());
        viewDataTab = new QWidget();
        viewDataTab->setObjectName(QString::fromUtf8("viewDataTab"));
        verticalLayout_3 = new QVBoxLayout(viewDataTab);
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        viewDataLayout = new QHBoxLayout();
        viewDataLayout->setObjectName(QString::fromUtf8("viewDataLayout"));
        statsCB = new QComboBox(viewDataTab);
        statsCB->addItem(QString());
        statsCB->addItem(QString());
        statsCB->addItem(QString());
        statsCB->setObjectName(QString::fromUtf8("statsCB"));

        viewDataLayout->addWidget(statsCB);

        yearCB = new QComboBox(viewDataTab);
        yearCB->addItem(QString());
        yearCB->setObjectName(QString::fromUtf8("yearCB"));

        viewDataLayout->addWidget(yearCB);

        refreshBtn = new QPushButton(viewDataTab);
        refreshBtn->setObjectName(QString::fromUtf8("refreshBtn"));

        viewDataLayout->addWidget(refreshBtn);


        verticalLayout_3->addLayout(viewDataLayout);

        viewDataTbl = new QTableWidget(viewDataTab);
        viewDataTbl->setObjectName(QString::fromUtf8("viewDataTbl"));

        verticalLayout_3->addWidget(viewDataTbl);

        mainTabWidget->addTab(viewDataTab, QString());
        playerCompTab = new QWidget();
        playerCompTab->setObjectName(QString::fromUtf8("playerCompTab"));
        verticalLayout_6 = new QVBoxLayout(playerCompTab);
        verticalLayout_6->setObjectName(QString::fromUtf8("verticalLayout_6"));
        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6->setObjectName(QString::fromUtf8("horizontalLayout_6"));
        playerCompPositionLbl = new QLabel(playerCompTab);
        playerCompPositionLbl->setObjectName(QString::fromUtf8("playerCompPositionLbl"));

        horizontalLayout_6->addWidget(playerCompPositionLbl);

        playerCompPositionCb = new QComboBox(playerCompTab);
        playerCompPositionCb->addItem(QString());
        playerCompPositionCb->addItem(QString());
        playerCompPositionCb->addItem(QString());
        playerCompPositionCb->addItem(QString());
        playerCompPositionCb->setObjectName(QString::fromUtf8("playerCompPositionCb"));

        horizontalLayout_6->addWidget(playerCompPositionCb);


        verticalLayout_6->addLayout(horizontalLayout_6);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4->setObjectName(QString::fromUtf8("horizontalLayout_4"));
        playerCompPlayerSelectLbl = new QLabel(playerCompTab);
        playerCompPlayerSelectLbl->setObjectName(QString::fromUtf8("playerCompPlayerSelectLbl"));

        horizontalLayout_4->addWidget(playerCompPlayerSelectLbl);

        playerCompPlayerSelectCb = new QComboBox(playerCompTab);
        playerCompPlayerSelectCb->setObjectName(QString::fromUtf8("playerCompPlayerSelectCb"));

        horizontalLayout_4->addWidget(playerCompPlayerSelectCb);


        verticalLayout_6->addLayout(horizontalLayout_4);

        findCompBtn = new QPushButton(playerCompTab);
        findCompBtn->setObjectName(QString::fromUtf8("findCompBtn"));

        verticalLayout_6->addWidget(findCompBtn);

        horizontalLayout_5 = new QHBoxLayout();
        horizontalLayout_5->setObjectName(QString::fromUtf8("horizontalLayout_5"));
        verticalLayout_7 = new QVBoxLayout();
        verticalLayout_7->setObjectName(QString::fromUtf8("verticalLayout_7"));
        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_7->addItem(verticalSpacer);


        horizontalLayout_5->addLayout(verticalLayout_7);

        verticalLayout_9 = new QVBoxLayout();
        verticalLayout_9->setObjectName(QString::fromUtf8("verticalLayout_9"));
        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_9->addItem(verticalSpacer_2);


        horizontalLayout_5->addLayout(verticalLayout_9);


        verticalLayout_6->addLayout(horizontalLayout_5);

        mainTabWidget->addTab(playerCompTab, QString());

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

        mainTabWidget->setCurrentIndex(2);


        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "John's Big FF Project", nullptr));
        ingestLbl->setText(QCoreApplication::translate("MainWindow", "Ingest", nullptr));
        statsTypeDB->setItemText(0, QCoreApplication::translate("MainWindow", "rushing stats", nullptr));
        statsTypeDB->setItemText(1, QCoreApplication::translate("MainWindow", "passing stats", nullptr));
        statsTypeDB->setItemText(2, QCoreApplication::translate("MainWindow", "receiving stats", nullptr));

        ingestForTheYearLbl->setText(QCoreApplication::translate("MainWindow", "for the year", nullptr));
        ingestUsingLbl->setText(QCoreApplication::translate("MainWindow", "using", nullptr));
        fileBrowserBtn->setText(QCoreApplication::translate("MainWindow", "File Browser", nullptr));
        ingestBtn->setText(QCoreApplication::translate("MainWindow", "Send to DB", nullptr));
        mainTabWidget->setTabText(mainTabWidget->indexOf(ingestTab), QCoreApplication::translate("MainWindow", "Ingest Data", nullptr));
        statsCB->setItemText(0, QCoreApplication::translate("MainWindow", "Rushing Stats", nullptr));
        statsCB->setItemText(1, QCoreApplication::translate("MainWindow", "Passing Stats", nullptr));
        statsCB->setItemText(2, QCoreApplication::translate("MainWindow", "Receiving Stats", nullptr));

        yearCB->setItemText(0, QCoreApplication::translate("MainWindow", "All Years", nullptr));

        refreshBtn->setText(QCoreApplication::translate("MainWindow", "Refresh", nullptr));
        mainTabWidget->setTabText(mainTabWidget->indexOf(viewDataTab), QCoreApplication::translate("MainWindow", "View Tabular Data", nullptr));
        playerCompPositionLbl->setText(QCoreApplication::translate("MainWindow", "Select Player Position:", nullptr));
        playerCompPositionCb->setItemText(0, QCoreApplication::translate("MainWindow", "QB", nullptr));
        playerCompPositionCb->setItemText(1, QCoreApplication::translate("MainWindow", "RB", nullptr));
        playerCompPositionCb->setItemText(2, QCoreApplication::translate("MainWindow", "WR", nullptr));
        playerCompPositionCb->setItemText(3, QCoreApplication::translate("MainWindow", "TE", nullptr));

        playerCompPlayerSelectLbl->setText(QCoreApplication::translate("MainWindow", "Player To Compare Against:", nullptr));
        findCompBtn->setText(QCoreApplication::translate("MainWindow", "Find Comp", nullptr));
        mainTabWidget->setTabText(mainTabWidget->indexOf(playerCompTab), QCoreApplication::translate("MainWindow", "Find Player Comp", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
