package com.ennova.emptyproject.base.view;

/**
 * View 基类
 */

public interface AbstractView {


    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Reload
     */
    void reload();

    /**
     * Show toast
     * @param message Message
     */
    void showToast(String message);

}
