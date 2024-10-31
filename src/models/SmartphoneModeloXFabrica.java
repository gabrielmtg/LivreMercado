package models;

public class SmartphoneModeloXFabrica implements DispositivoFactory{
    @Override
    public DispositivoLocalizador criaDispositivoLocalizador() {
        return new DispositivoGPS6745X();
    }

    @Override
    public DispositivoDataProvider criaDispositivoDataProvider() {
        return new DataProviderRTC6795X();
    }
}
