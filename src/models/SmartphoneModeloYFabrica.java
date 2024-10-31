package models;

public class SmartphoneModeloYFabrica implements DispositivoFactory{
    @Override
    public DispositivoLocalizador criaDispositivoLocalizador() {
        return new DispositivoGPSActive9202Y();
    }

    @Override
    public DispositivoDataProvider criaDispositivoDataProvider() {
        return new DataProviderRTCSuper9212Y();
    }
}
