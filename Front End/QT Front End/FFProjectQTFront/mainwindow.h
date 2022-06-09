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

private:
    Ui::MainWindow *ui;
};
#endif // MAINWINDOW_H
