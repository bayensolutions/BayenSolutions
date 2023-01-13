package com.bayensolutions.model;

import java.time.LocalDateTime;

public class PurchaseOrder {

    private Integer idPurchaseOrder;
    private Integer status;
    private Integer idPartnerCompany;
    private LocalDateTime dateTime;
    private Integer employeeId;

    public PurchaseOrder(Integer id, Integer status, Integer idPartnerCompany, LocalDateTime dateTime, Integer employeeId) {
        this.idPurchaseOrder = id;
        this.status=status;
        this.idPartnerCompany = idPartnerCompany;
        this.dateTime = dateTime;
        this.employeeId=employeeId;
    }

    public Integer getId() {
        return idPurchaseOrder;
    }

    public void setId(Integer id) {
        this.idPurchaseOrder = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdPartnerCompany() {
        return idPartnerCompany;
    }

    public void setIdPartnerCompany(Integer idPartnerCompany) {
        this.idPartnerCompany = idPartnerCompany;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "idPurchaseOrder=" + idPurchaseOrder +
                ", status=" + status +
                ", idPartnerCompany=" + idPartnerCompany +
                ", dateTime=" + dateTime +
                ", employeeId=" + employeeId +
                '}';
    }
}
