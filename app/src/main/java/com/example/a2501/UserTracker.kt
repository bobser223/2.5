package com.example.a2501

import android.content.Context

object UserTracker {
    private val listeners = mutableListOf<Context>()

    /*
     * Частина 1. Початкова реалізація зі штучним витоком пам'яті:
     * Activity зберігалася у singleton і ніколи з нього не видалялася.
     *
     * fun register(context: Context) {
     *     listeners.add(context)
     * }
     */

    /*
     * Частина 3, спосіб A. Зберігаємо тільки глобальний контекст застосунку:
     *
     * fun register(context: Context) {
     *     listeners.add(context.applicationContext)
     * }
     *
     * У цьому варіанті onDestroy() не повинен викликати unregister(this),
     * бо у списку зберігається applicationContext, а не Activity.
     */

    // Частина 3, спосіб B — фінальна активна реалізація.
    // Activity Context можна зберігати, якщо гарантовано видаляти його в onDestroy().
    fun register(context: Context) {
        listeners.add(context)
    }

    fun unregister(context: Context) {
        listeners.remove(context)
    }

    fun getListenersCount(): Int = listeners.size
}
