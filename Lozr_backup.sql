USE [master]
GO
/****** Object:  Database [LOZR]    Script Date: 05/11/2021 21:13:20 ******/
CREATE DATABASE [LOZR]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LOZR', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\LOZR.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'LOZR_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\LOZR_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [LOZR] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LOZR].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LOZR] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LOZR] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LOZR] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LOZR] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LOZR] SET ARITHABORT OFF 
GO
ALTER DATABASE [LOZR] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LOZR] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LOZR] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LOZR] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LOZR] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LOZR] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LOZR] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LOZR] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LOZR] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LOZR] SET  ENABLE_BROKER 
GO
ALTER DATABASE [LOZR] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LOZR] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LOZR] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LOZR] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LOZR] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LOZR] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LOZR] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LOZR] SET RECOVERY FULL 
GO
ALTER DATABASE [LOZR] SET  MULTI_USER 
GO
ALTER DATABASE [LOZR] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LOZR] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LOZR] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LOZR] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [LOZR] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [LOZR] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'LOZR', N'ON'
GO
ALTER DATABASE [LOZR] SET QUERY_STORE = OFF
GO
USE [LOZR]
GO
/****** Object:  Table [dbo].[BookMark]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookMark](
	[UserID] [int] NOT NULL,
	[ThreadID] [int] NOT NULL,
 CONSTRAINT [PK_BookMark] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[ThreadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Forum]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Forum](
	[ForumID] [int] IDENTITY(1,1) NOT NULL,
	[ForumName] [nvarchar](max) NOT NULL,
	[ForumImage] [varchar](max) NULL,
	[ForumIsActive] [bit] NOT NULL,
 CONSTRAINT [PK__TOPIC__022E0F5D9699E009] PRIMARY KEY CLUSTERED 
(
	[ForumID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[PostID] [int] IDENTITY(1,1) NOT NULL,
	[PostSubject] [ntext] NULL,
	[PostUserID] [int] NOT NULL,
	[PostThreadID] [int] NOT NULL,
	[PostReplyTo] [int] NULL,
	[PostDateCreated] [datetime] NULL,
	[PostIsActive] [bit] NOT NULL,
 CONSTRAINT [PK__POST__AA1260180363DD2B] PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post_Report]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_Report](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PostID] [int] NOT NULL,
	[Reason] [ntext] NULL,
	[ReportTime] [datetime] NOT NULL,
 CONSTRAINT [PK_Post_Report] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [IX_Post_Report] UNIQUE NONCLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thread]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thread](
	[ThreadID] [int] IDENTITY(1,1) NOT NULL,
	[ThreadSubject] [nvarchar](max) NOT NULL,
	[ThreadStartedBy] [int] NOT NULL,
	[ThreadDateCreated] [datetime] NULL,
	[ThreadIsActive] [bit] NULL,
	[ThreadForumID] [int] NULL,
 CONSTRAINT [PK__THREAD__688356846DABA36B] PRIMARY KEY CLUSTERED 
(
	[ThreadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thread_Report]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thread_Report](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ThreadID] [int] NOT NULL,
	[Reason] [ntext] NULL,
	[ReportTime] [datetime] NOT NULL,
 CONSTRAINT [PK_Thread_Report] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [IX_Thread_Report] UNIQUE NONCLUSTERED 
(
	[ThreadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Forum]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Forum](
	[UserID] [int] NOT NULL,
	[ForumID] [int] NOT NULL,
 CONSTRAINT [PK_User_Moderator] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[ForumID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Report]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Report](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[Reason] [ntext] NOT NULL,
	[ReportTime] [datetime] NOT NULL,
 CONSTRAINT [PK_User_Report] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[UserLoginName] [nvarchar](300) NULL,
	[UserPasswordHash] [binary](64) NULL,
	[UserFirstName] [nvarchar](300) NULL,
	[UserLastName] [nvarchar](300) NULL,
	[UserEmailAddress] [varchar](300) NULL,
	[UserImageAvatar] [varchar](300) NULL,
	[UserDateJoined] [datetime] NOT NULL,
	[UserIsActive] [bit] NULL,
	[UserIsMod] [bit] NOT NULL,
 CONSTRAINT [PK__USERINFO__1788CC4C648F04ED] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__UserInfo__DED24C9A768CD44C] UNIQUE NONCLUSTERED 
(
	[UserLoginName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Forum] ADD  CONSTRAINT [DF_Forum_ForumActive_1]  DEFAULT ((1)) FOR [ForumIsActive]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF_Post_PostDateCreated]  DEFAULT (getdate()) FOR [PostDateCreated]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF__POST__Hide__34C8D9D1]  DEFAULT ((1)) FOR [PostIsActive]
GO
ALTER TABLE [dbo].[Post_Report] ADD  CONSTRAINT [DF_Post_Report_ReportDate]  DEFAULT (getdate()) FOR [ReportTime]
GO
ALTER TABLE [dbo].[Thread] ADD  CONSTRAINT [DF_Thread_ThreadDateCreated]  DEFAULT (getdate()) FOR [ThreadDateCreated]
GO
ALTER TABLE [dbo].[Thread] ADD  CONSTRAINT [DF_Thread_ThreadIsActive]  DEFAULT ((1)) FOR [ThreadIsActive]
GO
ALTER TABLE [dbo].[Thread_Report] ADD  CONSTRAINT [DF_Thread_Report_ReportDate]  DEFAULT (getdate()) FOR [ReportTime]
GO
ALTER TABLE [dbo].[User_Report] ADD  CONSTRAINT [DF_User_Report_ReportDate]  DEFAULT (getdate()) FOR [ReportTime]
GO
ALTER TABLE [dbo].[UserInfo] ADD  CONSTRAINT [DF_User_UserDateJoined]  DEFAULT (getdate()) FOR [UserDateJoined]
GO
ALTER TABLE [dbo].[UserInfo] ADD  CONSTRAINT [DF_UserInfo_UserIsActive]  DEFAULT ((1)) FOR [UserIsActive]
GO
ALTER TABLE [dbo].[UserInfo] ADD  CONSTRAINT [DF__USERINFO__Admin__286302EC]  DEFAULT ((0)) FOR [UserIsMod]
GO
ALTER TABLE [dbo].[BookMark]  WITH CHECK ADD  CONSTRAINT [FK_BookMark_Thread] FOREIGN KEY([ThreadID])
REFERENCES [dbo].[Thread] ([ThreadID])
GO
ALTER TABLE [dbo].[BookMark] CHECK CONSTRAINT [FK_BookMark_Thread]
GO
ALTER TABLE [dbo].[BookMark]  WITH CHECK ADD  CONSTRAINT [FK_BookMark_UserInfo] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserInfo] ([UserID])
GO
ALTER TABLE [dbo].[BookMark] CHECK CONSTRAINT [FK_BookMark_UserInfo]
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Post1] FOREIGN KEY([PostReplyTo])
REFERENCES [dbo].[Post] ([PostID])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Post1]
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Thread1] FOREIGN KEY([PostThreadID])
REFERENCES [dbo].[Thread] ([ThreadID])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Thread1]
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_User1] FOREIGN KEY([PostUserID])
REFERENCES [dbo].[UserInfo] ([UserID])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_User1]
GO
ALTER TABLE [dbo].[Post_Report]  WITH CHECK ADD  CONSTRAINT [FK_Post_Report_Post1] FOREIGN KEY([PostID])
REFERENCES [dbo].[Post] ([PostID])
GO
ALTER TABLE [dbo].[Post_Report] CHECK CONSTRAINT [FK_Post_Report_Post1]
GO
ALTER TABLE [dbo].[Thread]  WITH CHECK ADD  CONSTRAINT [FK_Thread_Forum] FOREIGN KEY([ThreadForumID])
REFERENCES [dbo].[Forum] ([ForumID])
GO
ALTER TABLE [dbo].[Thread] CHECK CONSTRAINT [FK_Thread_Forum]
GO
ALTER TABLE [dbo].[Thread]  WITH CHECK ADD  CONSTRAINT [FK_Thread_User] FOREIGN KEY([ThreadStartedBy])
REFERENCES [dbo].[UserInfo] ([UserID])
GO
ALTER TABLE [dbo].[Thread] CHECK CONSTRAINT [FK_Thread_User]
GO
ALTER TABLE [dbo].[Thread_Report]  WITH CHECK ADD  CONSTRAINT [FK_Thread_Report_Thread1] FOREIGN KEY([ThreadID])
REFERENCES [dbo].[Thread] ([ThreadID])
GO
ALTER TABLE [dbo].[Thread_Report] CHECK CONSTRAINT [FK_Thread_Report_Thread1]
GO
ALTER TABLE [dbo].[User_Forum]  WITH CHECK ADD  CONSTRAINT [FK_User_Moderator_Forum] FOREIGN KEY([ForumID])
REFERENCES [dbo].[Forum] ([ForumID])
GO
ALTER TABLE [dbo].[User_Forum] CHECK CONSTRAINT [FK_User_Moderator_Forum]
GO
ALTER TABLE [dbo].[User_Forum]  WITH CHECK ADD  CONSTRAINT [FK_User_Moderator_UserInfo] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserInfo] ([UserID])
GO
ALTER TABLE [dbo].[User_Forum] CHECK CONSTRAINT [FK_User_Moderator_UserInfo]
GO
ALTER TABLE [dbo].[User_Report]  WITH CHECK ADD  CONSTRAINT [FK_User_Report_UserInfo1] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserInfo] ([UserID])
GO
ALTER TABLE [dbo].[User_Report] CHECK CONSTRAINT [FK_User_Report_UserInfo1]
GO
/****** Object:  StoredProcedure [dbo].[AddUser]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[AddUser]
    @pLoginName NVARCHAR(300), 
    @pPassword VARCHAR(300), 
    @pFirstName NVARCHAR(300) = NULL, 
    @pLastName NVARCHAR(300) = NULL,
	@pEmail VARCHAR(300) = NULL,
	@pImage VARCHAR(300) = NULL
AS
			BEGIN
				INSERT INTO UserInfo(UserLoginName, UserPasswordHash, UserFirstName, UserLastName, UserEmailAddress, UserImageAvatar)
				VALUES(@pLoginName,HASHBYTES('SHA2_512', @pPassword),  @pFirstName, @pLastName, @pEmail, @pImage)
				DECLARE @pUserID INT = (SELECT @@IDENTITY AS UserID)
			END

GO
/****** Object:  StoredProcedure [dbo].[verifyUser]    Script Date: 05/11/2021 21:13:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[verifyUser]
	@pLoginName NVARCHAR(300),
	@pPassword VARCHAR(300)
AS
BEGIN
SELECT U.UserID, U.UserLoginName, U.UserFirstName, U.UserLastName,
	U.UserEmailAddress, U.UserImageAvatar, U.UserDateJoined, U.UserPasswordHash,U.UserIsMod
FROM UserInfo AS U
WHERE UserPasswordHash=HASHBYTES('SHA2_512', @pPassword) AND @pLoginName=UserLoginName
	AND UserIsActive = 1
END
GO
USE [master]
GO
ALTER DATABASE [LOZR] SET  READ_WRITE 
GO
