package com.itus.cowa.model

object ParentFactory {
    fun getAllParents(): List<Parent> {
        val result: MutableList<Parent> = ArrayList()
        result.add(Parent("Hôm nay", TransactionFactory.concreteList))
        result.add(Parent("Hôm qua", TransactionFactory.concreteList.subList(0, 3)))
        result.add(Parent("25/12/2020", TransactionFactory.concreteList.subList(1, 4)))
        result.add(Parent("24/12/2020", TransactionFactory.getListSpend()))
        return result
    }

    fun getListSpend(): List<Parent> {
        val result: MutableList<Parent> = ArrayList()
        result.add(Parent("Hôm nay", TransactionFactory.getListSpend()))
        result.add(Parent("Hôm qua", TransactionFactory.getListSpend()))
        return result
    }

    fun getListReceipt(): List<Parent> {
        val result: MutableList<Parent> = ArrayList()
        result.add(Parent("Hôm nay", TransactionFactory.getListReceipt()))
        result.add(Parent("Hôm qua", TransactionFactory.getListReceipt()))
        return result
    }
}
