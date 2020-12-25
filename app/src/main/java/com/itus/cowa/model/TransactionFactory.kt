package com.itus.cowa.model

import com.itus.cowa.R

object TransactionFactory {
    val concreteList: MutableList<Transaction>

    init {
        concreteList = ArrayList()
        concreteList.add(Transaction(R.drawable.ic_shopping_basket_1, "MiniStop", "Mua đồ tạp hóa", -100000))
        concreteList.add(Transaction(R.drawable.ic_soup_1, "Texas Chicken", "Ăn tối", -50000))
        concreteList.add(Transaction(R.drawable.ic_sedan_1, "Uber", "Đi làm", -20000))
        concreteList.add(Transaction(R.drawable.ic_money_bag_1, "Office", "Tiền lương", 4000000))
        concreteList.add(Transaction(R.drawable.ic_money_bag_1, "Bán đồ", "Bán macboock", 10000000))
    }

    fun getListReceipt(): List<Transaction> {
        concreteList.subList(0, concreteList.size)
        val result: MutableList<Transaction> = ArrayList()
        for (transaction in concreteList)
            if (transaction.amount > 0) result.add(transaction)
        return result
    }

    fun getListSpend(): List<Transaction> {
        concreteList.subList(0, concreteList.size)
        val result: MutableList<Transaction> = ArrayList()
        for (transaction in concreteList)
            if (transaction.amount < 0) result.add(transaction)
        return result
    }
}