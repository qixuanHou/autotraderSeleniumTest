package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimVehicleHistoryPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By nextButtonSelector;
    private By noAutoAuctionSelector;
    private By noAutoAuctionValidationSelector;
    private By noInsuranceClaimsSelector;
    private By noInsuranceClaimsValidationSelector;
    private By noRentalCarSelector;
    private By noRentalCarValidationSelector;
    private By noSmokingInVehicleSelector;
    private By noSmokingInVehicleValidationSelector;
    private By yesCleanHistoryReportSelector;
    private By yesCleanHistoryReportValidationSelector;
    private By yesClearTitleSelector;
    private By yesClearTitleValidationSelector;
    private By yesCompleteServiceRecordsSelector;
    private By yesCompleteServiceRecordsValidationSelector;
    private By yesOriginalOwnerSelector;
    private By yesOriginalOwnerValidationSelector;
    private By yesTwoSetsOfKeysSelector;
    private By yesTwoSetsOfKeysValidationSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimVehicleHistoryPageSelector object.
     */
    public TimVehicleHistoryPageSelector() {
        initTimVehicleHistoryPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getNextButtonSelector() {
        return nextButtonSelector;
    }

    public By getNoAutoAuctionSelector() {
        return noAutoAuctionSelector;
    }

    public By getNoAutoAuctionValidationSelector() {
        return noAutoAuctionValidationSelector;
    }

    public By getNoInsuranceClaimsSelector() {
        return noInsuranceClaimsSelector;
    }

    public By getNoInsuranceClaimsValidationSelector() {
        return noInsuranceClaimsValidationSelector;
    }

    public By getNoRentalCarSelector() {
        return noRentalCarSelector;
    }

    public By getNoRentalCarValidationSelector() {
        return noRentalCarValidationSelector;
    }

    public By getNoSmokingInVehicleSelector() {
        return noSmokingInVehicleSelector;
    }

    public By getNoSmokingInVehicleValidationSelector() {
        return noSmokingInVehicleValidationSelector;
    }

    public By getYesCleanHistoryReportSelector() {
        return yesCleanHistoryReportSelector;
    }

    public By getYesCleanHistoryReportValidationSelector() {
        return yesCleanHistoryReportValidationSelector;
    }

    public By getYesClearTitleSelector() {
        return yesClearTitleSelector;
    }

    public By getYesClearTitleValidationSelector() {
        return yesClearTitleValidationSelector;
    }

    public By getYesCompleteServiceRecordsSelector() {
        return yesCompleteServiceRecordsSelector;
    }

    public By getYesCompleteServiceRecordsValidationSelector() {
        return yesCompleteServiceRecordsValidationSelector;
    }

    public By getYesOriginalOwnerSelector() {
        return yesOriginalOwnerSelector;
    }

    public By getYesOriginalOwnerValidationSelector() {
        return yesOriginalOwnerValidationSelector;
    }

    public By getYesTwoSetsOfKeysSelector() {
        return yesTwoSetsOfKeysSelector;
    }

    public By getYesTwoSetsOfKeysValidationSelector() {
        return yesTwoSetsOfKeysValidationSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimVehicleHistoryPageOptions() {
        yesOriginalOwnerSelector = By.xpath(".//label[contains(@for, '83_choices-0')]");
        yesClearTitleSelector = By.xpath(".//label[contains(@for, '82_choices-0')]");
        yesCleanHistoryReportSelector = By.xpath(".//label[contains(@for, '124_choices-0')]");
        noInsuranceClaimsSelector = By.xpath(".//label[contains(@for, '76_choices-1')]");
        noSmokingInVehicleSelector = By.xpath(".//label[contains(@for, '65_choices-1')]");
        yesCompleteServiceRecordsSelector = By.xpath(".//label[contains(@for, '17_choices-0')]");
        yesTwoSetsOfKeysSelector = By.xpath(".//label[contains(@for, '79_choices-0')]");
        noAutoAuctionSelector = By.xpath(".//label[contains(@for, '81_choices-1')]");
        noRentalCarSelector = By.xpath(".//label[contains(@for, '125_choices-1')]");
        nextButtonSelector = By.xpath("//input[contains(@value, 'Next')]");
        yesOriginalOwnerValidationSelector = By.id("qp_83_error");
        yesClearTitleValidationSelector = By.id("qp_82_error");
        yesCleanHistoryReportValidationSelector = By.id("qp_124_error");
        noInsuranceClaimsValidationSelector = By.id("qp_76_error");
        noSmokingInVehicleValidationSelector = By.id("qp_65_error");
        yesCompleteServiceRecordsValidationSelector = By.id("qp_17_error");
        yesTwoSetsOfKeysValidationSelector = By.id("qp_79_error");
        noAutoAuctionValidationSelector = By.id("qp_81_error");
        noRentalCarValidationSelector = By.id("qp_125_error");
    }
}
