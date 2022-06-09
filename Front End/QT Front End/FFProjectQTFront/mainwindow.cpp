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
    }
    //add the year
    urlString += "?year=" + ui->yearEdit->text();
    //add the filename
    QString csvFileLoc = ui->fileNameEdit->text();
    csvFileLoc.replace("/", "%2F");
    urlString += "&csvFile=" + csvFileLoc;

    ui->ingestConsole->setPlainText("going to send to url \n" + urlString);

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
    ui->ingestConsole->setPlainText(QString::fromStdString(response.toStdString()));
}

