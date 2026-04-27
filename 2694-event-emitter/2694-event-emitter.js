class EventEmitter {
    constructor() {
        this.events = {}
    }

    subscribe(eventName, callback) {
        if (!this.events[eventName]) {
            this.events[eventName] = []
        }

        const list = this.events[eventName]
        list.push(callback)
        const index = list.length - 1

        return {
            unsubscribe: () => {
                list[index] = null
            }
        }
    }

    emit(eventName, args = []) {
        if (!this.events[eventName]) return []

        const res = []

        for (let cb of this.events[eventName]) {
            if (cb) {
                res.push(cb(...args))
            }
        }

        return res
    }
}