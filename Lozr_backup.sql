USE [master]
GO
/****** Object:  Database [LOZR]    Script Date: 21/10/2021 10:36:21 ******/
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
/****** Object:  Table [dbo].[BookMark]    Script Date: 21/10/2021 10:36:22 ******/
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
/****** Object:  Table [dbo].[Feature]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[FeatureID] [int] IDENTITY(1,1) NOT NULL,
	[Url] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[FeatureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Forum]    Script Date: 21/10/2021 10:36:22 ******/
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
/****** Object:  Table [dbo].[Group]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group](
	[GroupID] [int] IDENTITY(1,1) NOT NULL,
	[GroupName] [nvarchar](150) NULL,
 CONSTRAINT [PK_Group] PRIMARY KEY CLUSTERED 
(
	[GroupID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GroupFeature]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupFeature](
	[GroupID] [int] NOT NULL,
	[FeatureID] [int] NOT NULL,
 CONSTRAINT [PK_GroupFeature] PRIMARY KEY CLUSTERED 
(
	[GroupID] ASC,
	[FeatureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 21/10/2021 10:36:22 ******/
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
	[PostUpVote] [int] NULL,
	[PostDownVote] [int] NULL,
	[PostDateCreated] [datetime] NULL,
	[PostIsActive] [bit] NOT NULL,
 CONSTRAINT [PK__POST__AA1260180363DD2B] PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post_Report]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_Report](
	[PostID] [int] NOT NULL,
	[ReportDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Post_Report] PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thread]    Script Date: 21/10/2021 10:36:22 ******/
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
/****** Object:  Table [dbo].[Thread_Report]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thread_Report](
	[ThreadID] [int] NOT NULL,
	[ReportDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Thread_Report_1] PRIMARY KEY CLUSTERED 
(
	[ThreadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserGroup]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserGroup](
	[UserID] [int] NOT NULL,
	[GroupID] [int] NOT NULL,
 CONSTRAINT [PK_UserGroup] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[GroupID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[UserLoginName] [nvarchar](40) NULL,
	[UserPasswordHash] [binary](64) NULL,
	[UserFirstName] [nvarchar](40) NULL,
	[UserLastName] [nvarchar](40) NULL,
	[UserEmailAddress] [varchar](max) NULL,
	[UserImageAvatar] [varchar](max) NULL,
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
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Forum] ADD  CONSTRAINT [DF_Forum_ForumActive_1]  DEFAULT ((1)) FOR [ForumIsActive]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF_Post_PostUpVote]  DEFAULT ((0)) FOR [PostUpVote]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF_Post_PostDownVote]  DEFAULT ((0)) FOR [PostDownVote]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF_Post_PostDateCreated]  DEFAULT (getdate()) FOR [PostDateCreated]
GO
ALTER TABLE [dbo].[Post] ADD  CONSTRAINT [DF__POST__Hide__34C8D9D1]  DEFAULT ((1)) FOR [PostIsActive]
GO
ALTER TABLE [dbo].[Post_Report] ADD  CONSTRAINT [DF_Post_Report_ReportDate]  DEFAULT (getdate()) FOR [ReportDate]
GO
ALTER TABLE [dbo].[Thread] ADD  CONSTRAINT [DF_Thread_ThreadDateCreated]  DEFAULT (getdate()) FOR [ThreadDateCreated]
GO
ALTER TABLE [dbo].[Thread] ADD  CONSTRAINT [DF_Thread_ThreadIsActive]  DEFAULT ((1)) FOR [ThreadIsActive]
GO
ALTER TABLE [dbo].[Thread_Report] ADD  CONSTRAINT [DF_Thread_Report_ReportDate]  DEFAULT (getdate()) FOR [ReportDate]
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
ALTER TABLE [dbo].[GroupFeature]  WITH CHECK ADD  CONSTRAINT [FK_GroupFeature_Feature] FOREIGN KEY([GroupID])
REFERENCES [dbo].[Feature] ([FeatureID])
GO
ALTER TABLE [dbo].[GroupFeature] CHECK CONSTRAINT [FK_GroupFeature_Feature]
GO
ALTER TABLE [dbo].[GroupFeature]  WITH CHECK ADD  CONSTRAINT [FK_GroupFeature_Group] FOREIGN KEY([GroupID])
REFERENCES [dbo].[Group] ([GroupID])
GO
ALTER TABLE [dbo].[GroupFeature] CHECK CONSTRAINT [FK_GroupFeature_Group]
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
ALTER TABLE [dbo].[Post_Report]  WITH CHECK ADD  CONSTRAINT [FK_Post_Report_Post] FOREIGN KEY([PostID])
REFERENCES [dbo].[Post] ([PostID])
GO
ALTER TABLE [dbo].[Post_Report] CHECK CONSTRAINT [FK_Post_Report_Post]
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
ALTER TABLE [dbo].[Thread_Report]  WITH CHECK ADD  CONSTRAINT [FK_Thread_Report_Thread] FOREIGN KEY([ThreadID])
REFERENCES [dbo].[Thread] ([ThreadID])
GO
ALTER TABLE [dbo].[Thread_Report] CHECK CONSTRAINT [FK_Thread_Report_Thread]
GO
ALTER TABLE [dbo].[UserGroup]  WITH CHECK ADD  CONSTRAINT [FK_UserGroup_Group] FOREIGN KEY([GroupID])
REFERENCES [dbo].[Group] ([GroupID])
GO
ALTER TABLE [dbo].[UserGroup] CHECK CONSTRAINT [FK_UserGroup_Group]
GO
/****** Object:  StoredProcedure [dbo].[AddUser]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[AddUser]
    @pLoginName NVARCHAR(40), 
    @pPassword VARCHAR(40), 
    @pFirstName NVARCHAR(40) = NULL, 
    @pLastName NVARCHAR(40) = NULL,
	@pEmail VARCHAR(MAX) = NULL,
	@pImage VARCHAR(MAX) = NULL,
    @responseMessage NVARCHAR(250) OUTPUT
AS
BEGIN
    SET NOCOUNT ON

    BEGIN TRY
		BEGIN
			INSERT INTO UserInfo(UserLoginName, UserPasswordHash, UserFirstName, UserLastName, UserEmailAddress, UserImageAvatar)
			VALUES(@pLoginName,HASHBYTES('SHA2_512', @pPassword),  @pFirstName, @pLastName, @pEmail, @pImage)
		END		
        SET @responseMessage='Success'
    END TRY
    BEGIN CATCH
        SET @responseMessage='Error' 
    END CATCH
END
GO
/****** Object:  StoredProcedure [dbo].[getPost]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getPost]
	@pThreadID INT
AS
BEGIN
	SELECT P.PostID, P.PostSubject, P.PostThreadID, P.PostDateCreated,
	P.PostIsActive ,P.PostUserID, U.UserLoginName,  P.PostReplyTo,
	Rep.PostSubject AS RepPostSubject, Rep.PostDateCreated AS RepPostDateCreated, 
	Rep.PostIsActive AS RepPostIsActive, Rep.PostUserID AS RepPostUserID,
	URep.UserLoginName AS URepLoginName
	FROM POST AS P 
		JOIN UserInfo AS U ON P.PostUserID=U.UserID
		JOIN Post AS Rep ON P.PostReplyTo=Rep.PostID
		JOIN UserInfo AS URep ON Rep.PostUserID=URep.UserID
	WHERE P.PostThreadID=@pThreadID AND P.PostIsActive = 1
END
GO
/****** Object:  StoredProcedure [dbo].[updatePassword]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[updatePassword] 
	-- Add the parameters for the stored procedure here
	@pPassword varchar(40), 
	@pUserID int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE UserInfo
	SET UserPasswordHash=HASHBYTES('SHA2_512', @pPassword)
	WHERE UserID=@pUserID
END
GO
/****** Object:  StoredProcedure [dbo].[verifyUser]    Script Date: 21/10/2021 10:36:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[verifyUser]
	@pLoginName nvarchar(40),
	@pPassword varchar(40)
AS
BEGIN
SELECT UserID, UserLoginName, UserFirstName, UserLastName
	,UserEmailAddress, UserImageAvatar, UserDateJoined, UserIsMod, UserPasswordHash
FROM UserInfo  
WHERE UserPasswordHash=HASHBYTES('SHA2_512', @pPassword) AND @pLoginName=UserLoginName
	AND UserIsActive = 1
END
GO
USE [master]
GO
ALTER DATABASE [LOZR] SET  READ_WRITE 
GO
