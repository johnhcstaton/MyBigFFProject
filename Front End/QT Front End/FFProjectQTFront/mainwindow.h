#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QNetworkReply>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_fileBrowserBtn_released();
    void fileSelected(QString);

    //ingest slots
    void on_ingestBtn_released();
    void onFinish(QNetworkReply*);

    void on_mainTabWidget_currentChanged(int index);

    void on_playerCompPositionCb_currentTextChanged(const QString &arg1);
    void on_getAllPlayersForPositionForPlayerComp(QNetworkReply*);

    void on_findCompBtn_released();
    void playerCompEndpointReplied(QNetworkReply*);

private:
    Ui::MainWindow *ui;
};
#endif // MAINWINDOW_H
