package com.websocket.chat.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatId", nullable = false, columnDefinition = "int")
    private Long chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "roomId")
    @NotNull
    private Room roomId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    @JoinColumn(name = "userId")
//    @NotNull
//    private Users users;

    @NotNull
    private String userName;

    @Column(name = "chatContent", nullable = false, columnDefinition = "text")
    private String chatContent;


    // 협의 필요
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "chatDate", nullable = false, columnDefinition = "timestamp")
    private Date chatDate;
}
