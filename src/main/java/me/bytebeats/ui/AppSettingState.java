package me.bytebeats.ui;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "me.bytebeats.ui.AppSettingState", storages = {@Storage("mns_plugin_setting.xml")})
public class AppSettingState implements PersistentStateComponent<AppSettingState> {

    public final static boolean IS_RED_RISE = true;
    public final static boolean IS_HIDDEN_MODE = false;
    public final static boolean IS_CONCISE_MODE = false;
    public final static String US_STOCKS = "AAPL;TWTR;TSLA;NFLX;MSFT";
    public final static String HK_STOCKS = "00981;09988;09618";
    public final static String SH_STOCKS = "600036";
    public final static String SZ_STOCKS = "002352";
    public final static String DAILY_FUNDS = "320003;002621;519674";
    public final static String ALL_INDICES = "usDJI;usIXIC;hkHSI;hkHSCEI;hkHSCCI;sh000001;sz399001;sz399006;sh000300;sh000016;sz399903";
    public final static String STOCK_SYMBOL = "sh600519";
    public final static String FUND_SYMBOL = "570008";

    private boolean isRedRise = true;
    private boolean isHiddenMode = false;
    private boolean isConciseMode = false;
    private String usStocks = "AAPL;TWTR;TSLA;NFLX;MSFT";
    private String hkStocks = "00981;09988;09618";
    private String shStocks = "600036";
    private String szStocks = "002352";
    private String dailyFunds = "320003;002621;519674";
    private String stockSymbol = "usTSLA";
    private String fundSymbol = "570008";

    public static AppSettingState getInstance() {
        return ServiceManager.getService(AppSettingState.class);
    }

    public boolean deepCopy(@Nullable AppSettingState instance) {
        if (instance == null) {
//            reset();
            return false;
        } else {
            isRedRise = instance.isRedRise;
            isHiddenMode = instance.isHiddenMode;
            isConciseMode = instance.isConciseMode;
            usStocks = instance.usStocks;
            hkStocks = instance.hkStocks;
            shStocks = instance.shStocks;
            szStocks = instance.szStocks;
            dailyFunds = instance.dailyFunds;
            stockSymbol = instance.stockSymbol;
            fundSymbol = instance.fundSymbol;
            return true;
        }
    }

    public void reset() {
        setRedRise(IS_RED_RISE);
        setHiddenMode(IS_HIDDEN_MODE);
        setConciseMode(IS_CONCISE_MODE);
        setUsStocks(US_STOCKS);
        setHkStocks(HK_STOCKS);
        setShStocks(SH_STOCKS);
        setSzStocks(SZ_STOCKS);
        setDailyFunds(DAILY_FUNDS);
        setStockSymbol(STOCK_SYMBOL);
        setFundSymbol(FUND_SYMBOL);
    }

    @Nullable
    @Override
    public AppSettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingState appSettingState) {
        XmlSerializerUtil.copyBean(appSettingState, this);
    }

    public boolean isRedRise() {
        return isRedRise;
    }

    public void setRedRise(boolean redRise) {
        isRedRise = redRise;
    }

    public boolean isHiddenMode() {
        return isHiddenMode;
    }

    public void setHiddenMode(boolean hiddenMode) {
        isHiddenMode = hiddenMode;
    }

    public boolean isConciseMode() {
        return isConciseMode;
    }

    public void setConciseMode(boolean conciseMode) {
        isConciseMode = conciseMode;
    }

    public String getUsStocks() {
        return usStocks;
    }

    public void setUsStocks(String usStocks) {
        this.usStocks = usStocks;
    }

    public String getHkStocks() {
        return hkStocks;
    }

    public void setHkStocks(String hkStocks) {
        this.hkStocks = hkStocks;
    }

    public String getShStocks() {
        return shStocks;
    }

    public void setShStocks(String shStocks) {
        this.shStocks = shStocks;
    }

    public String getSzStocks() {
        return szStocks;
    }

    public void setSzStocks(String szStocks) {
        this.szStocks = szStocks;
    }

    public String getDailyFunds() {
        return dailyFunds;
    }

    public void setDailyFunds(String dailyFunds) {
        this.dailyFunds = dailyFunds;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getFundSymbol() {
        return fundSymbol;
    }

    public void setFundSymbol(String fundSymbol) {
        this.fundSymbol = fundSymbol;
    }
}
