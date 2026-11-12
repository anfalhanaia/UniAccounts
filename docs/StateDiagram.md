
stateDiagram-v2
    [*] --> PENDING

    PENDING --> ACTIVE: activate()
    PENDING --> CLOSED: close()

    ACTIVE --> SUSPENDED: suspend()
    ACTIVE --> CLOSED: close()

    SUSPENDED --> ACTIVE: activate()
    SUSPENDED --> CLOSED: close()

    CLOSED --> [*]

    note right of PENDING
        Login denied
    end note

    note right of ACTIVE
        Login allowed
    end note

    note right of SUSPENDED
        Login denied
    end note

    note right of CLOSED
        Login denied
        No further transitions
    end note
