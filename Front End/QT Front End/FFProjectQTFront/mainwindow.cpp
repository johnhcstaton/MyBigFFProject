#include "mainwindow.h"
#include "./ui_mainwindow.h"
#include <QFileDialog>
#include <QString>
#include <QNetworkAccessManager>
#include <QHttpPart>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_fileBrowserBtn_released()
{
    //Show a file dialog and set the text in the fileNameEdit
    QFileDialog * fileDialog = new QFileDialog();
    fileDialog->setVisible(true);
    connect(fileDialog, SIGNAL(fileSelected(QString)), this, SLOT(fileSelected(QString)));
    connect(fileDialog,SIGNAL(finished(QNetworkReply*)),fileDialog,SLOT(deleteLater()));
}

void MainWindow::fileSelected(QString fileString)
{
    ui->fileNameEdit->setText(fileString);
}


void MainWindow::on_ingestBtn_released()
{
    //Generate the url to send to backend, display results in ingestConsole
    QString urlString = "http://localhost:8080/api/ffproject/ingest/";
    //add the proper endpoint name for the stats type
    if(ui->statsTypeDB->currentIndex() == 0) {
        urlString += "ingestRushingStatsForYear";
    } else if(ui->statsTypeDB->currentIndex() == 1) {
        urlString += "ingestPassingStatsForYear";
    } else if(ui->statsTypeDB->currentIndex() == 2) {
        urlString += "ingestReceivingStatsForYear";
    }
    //add the year
    urlString += "?year=" + ui->yearEdit->text();
    //add the filename
    QString csvFileLoc = ui->fileNameEdit->text();
    csvFileLoc.replace("/", "%2F");
    urlString += "&csvFile=" + csvFileLoc;

    ui->ingestConsole->setPlainText(ui->ingestConsole->toPlainText() + "\n" + "going to send to url \n" + urlString);

    //url generated, do the sending and cross ya fingers
    QUrl url = QUrl(urlString);

    QNetworkAccessManager * mgr = new QNetworkAccessManager(this);

    connect(mgr,SIGNAL(finished(QNetworkReply*)),this,SLOT(onFinish(QNetworkReply*)));
    connect(mgr,SIGNAL(finished(QNetworkReply*)),mgr,SLOT(deleteLater()));


    mgr->post(QNetworkRequest(url), new QHttpMultiPart());
}

void MainWindow::onFinish(QNetworkReply * reply)
{
    QByteArray response = reply->readAll();
    ui->ingestConsole->setPlainText(ui->ingestConsole->toPlainText() + "\n" + QString::fromStdString(response.toStdString()));
}


void MainWindow::on_mainTabWidget_currentChanged(int index)
{
    switch (index) {
        case 0: //ingest
            break;
        case 1: //view tabular data
            break;
        case 2: // player comp
            // fill combo box with all players based on text in position combo box
            on_playerCompPositionCb_currentTextChanged(ui->playerCompPlayerSelectCb->currentText());
            break;
    }
}


void MainWindow::on_playerCompPositionCb_currentTextChanged(const QString &arg1)
{
    //player position changed, get new position and reload player combo box

}

