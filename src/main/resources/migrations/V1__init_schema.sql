CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ
);

ALTER TABLE users
ADD CONSTRAINT users_email_unique UNIQUE (email);

CREATE TABLE twitch_accounts (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    twitch_user_id BIGINT NOT NULL,
    twitch_login VARCHAR(255) NOT NULL,
    display_name VARCHAR(255) NOT NULL,
    profile_image_url VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ,

    CONSTRAINT twitch_accounts_user_id_unique UNIQUE (user_id),
    CONSTRAINT twitch_accounts_twitch_user_id_unique UNIQUE (twitch_user_id),
    CONSTRAINT twitch_accounts_user_id_fk
        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE oauth_tokens (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    provider VARCHAR(255) NOT NULL,
    access_token VARCHAR(255) NOT NULL,
    refresh_token VARCHAR(255) NOT NULL,
    expires_at TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ,

    CONSTRAINT oauth_tokens_user_provider_unique
        UNIQUE (user_id, provider),
    CONSTRAINT oauth_tokens_user_id_fk
        FOREIGN KEY (user_id) REFERENCES users(id)
);

COMMENT ON COLUMN oauth_tokens.provider
IS 'twitch, youtube, kick, etc.';
COMMENT ON COLUMN oauth_tokens.access_token
IS 'sensible, à stocker chiffré';
COMMENT ON COLUMN oauth_tokens.refresh_token
IS 'sensible, à stocker chiffré';

CREATE TABLE stream_sessions (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    is_live BOOLEAN NOT NULL,
    started_at TIMESTAMPTZ NOT NULL,
    ended_at TIMESTAMPTZ,

    CONSTRAINT stream_sessions_user_id_fk
        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE stream_settings (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    stream_title VARCHAR(255) NOT NULL,
    stream_description VARCHAR(255),
    game_category_id BIGINT NOT NULL,
    tags VARCHAR(255),

    CONSTRAINT stream_settings_user_id_unique UNIQUE (user_id),
    CONSTRAINT stream_settings_user_id_fk
        FOREIGN KEY (user_id) REFERENCES users(id)
);

COMMENT ON COLUMN stream_settings.game_category_id
IS 'ID de catégorie récupéré depuis l’API Twitch';

CREATE TABLE profile_settings (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    bio VARCHAR(255) NOT NULL,
    banner_image VARCHAR(255) NOT NULL,
    avatar_image VARCHAR(255) NOT NULL,
    social_links JSONB NOT NULL,

    CONSTRAINT profile_settings_user_id_unique UNIQUE (user_id),
    CONSTRAINT profile_settings_user_id_fk
        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE streamer_stats (
    id BIGSERIAL PRIMARY KEY,
    twitch_user_id BIGINT NOT NULL,
    followers_count BIGINT NOT NULL,
    viewers_avg BIGINT NOT NULL,
    stream_start_hour TIMESTAMPTZ NOT NULL,
    stream_end_hour TIMESTAMPTZ NOT NULL,
    last_updated TIMESTAMPTZ,

    CONSTRAINT streamer_stats_twitch_user_id_fk
        FOREIGN KEY (twitch_user_id)
        REFERENCES twitch_accounts(twitch_user_id)
);