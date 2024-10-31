package models;

public class SmartphoneModeloXFabrica implements DispositivoFactory{
    @Override
    public DispositivoLocalizador criaDispositivoLocalizador() {
        return null;
    }

    @Override
    public DispositivoDataProvider criaDispositivoDataProvider() {
        return null;
    }
}
